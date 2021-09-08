package br.com.unicoob.processor;

import br.com.unicoob.domain.dto.FuncionarioApiDTO;
import br.com.unicoob.domain.dto.OperatorGroupDTO;
import br.com.unicoob.domain.model.RhOperationLog;
import br.com.unicoob.domain.repository.RhOperationLogRepository;
import br.com.unicoob.domain.template.AdmissaoTemplate;
import br.com.unicoob.domain.type.OperationType;
import br.com.unicoob.topdesk.domain.build.RequestIncidentBuilder;
import br.com.unicoob.topdesk.domain.model.IncidentDTO;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChamadoAdmissaoProcessor implements Processor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChamadoAdmissaoProcessor.class);

    @Value("${servicos.top-desk.url}")
    private String urlTopDesk;

    @Value("${servicos.top-desk.basic-auth}")
    private String basicAuth;

    @Autowired
    RhOperationLogRepository logRepository;

    @Override
    public void process(Exchange exchange) throws Exception {
        FuncionarioApiDTO funcionario = (FuncionarioApiDTO) exchange.getIn().getBody();

        AdmissaoTemplate template = new AdmissaoTemplate(funcionario);
        for (OperatorGroupDTO operadorGroup : template.getOperatorGroups()) {

            List<RhOperationLog> logs = logRepository.findAllByOperationAndNumcadAndNumempAndNumcpfAndOperatorGroup(OperationType.ADMISSAO, Integer.valueOf(funcionario.getMatricula()), funcionario.getCooperativa().getCooperativa(), Long.valueOf(funcionario.getCpf()), operadorGroup.getNome());
            if(!logs.isEmpty()){
                continue;
            }

            ResponseEntity<IncidentDTO> incident = RequestIncidentBuilder.builder(basicAuth, urlTopDesk, 2009, 0)
                    .withCallerDynamicName("Robo 2009 - Central Unicoob")
                    .withOperatorGroupName(operadorGroup.getNome())
                    .withCategoryName(operadorGroup.getCategoryName())
                    .withSubcategoryName(operadorGroup.getSubcategoryName())
                    .withBriefDescription(template.getBriefDescription() + " - " + operadorGroup.getNomeAbreviado())
                    .withRequest(template.getRequest())
                    .withEntryTypeName("Portal")
                    .withCallTypeName("Solicitação")
                    .withImpactName("Minha Cooperativa")
                    .withUrgencyName("Baixo")
                    .createIncident();
            if (incident.getStatusCode().is2xxSuccessful() && incident.getBody()!= null) {
                String number = incident.getBody().getNumber();
                RhOperationLog operationLog = new RhOperationLog(funcionario, OperationType.ADMISSAO, number, operadorGroup.getNome());
                logRepository.save(operationLog);
                LOGGER.info("SUCESSO: {} - Aberto o chamado de {} do colaborador {} para o grupo {}", number, OperationType.ADMISSAO, funcionario.getNomeCompleto(), operadorGroup.getNome());
            } else{
                LOGGER.warn("FALHA: Não foi possivel abrir o chamado de {} do colaborador {} para o grupo {}", OperationType.ADMISSAO, funcionario.getNomeCompleto(), operadorGroup.getNome());
                LOGGER.info("StatusCode: {} e Retorno: {}", incident.getStatusCode(), incident.getBody());
            }

        }
    }
}