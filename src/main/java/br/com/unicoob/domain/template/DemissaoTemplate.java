package br.com.unicoob.domain.template;

import br.com.unicoob.domain.dto.FuncionarioApiDTO;
import br.com.unicoob.domain.dto.OperatorGroupDTO;
import br.com.unicoob.domain.interfaces.IChamados;
import br.com.unicoob.domain.type.OperationType;

import java.util.ArrayList;
import java.util.List;

public class DemissaoTemplate implements IChamados {

    FuncionarioApiDTO funcionario;


    public DemissaoTemplate(FuncionarioApiDTO funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public List<OperatorGroupDTO> getOperatorGroups() {
        ArrayList<OperatorGroupDTO> groups = new ArrayList<>();
        OperatorGroupDTO operatorGroupControleAcessoDTO = new OperatorGroupDTO("2009 - Controle de Acesso - Monitoria e Supervisao", "Controle de Acesso", "2009. Tecnologia - Acessos", "Desligamento funcionário");
        OperatorGroupDTO operatorGroupSuporteDTO = new OperatorGroupDTO("2009 - TI - Suporte", "Suporte", "2009. Tecnologia - Acessos", "Desligamento funcionário");
        OperatorGroupDTO operatorGroupConfederacaoDTO = new OperatorGroupDTO("Data Center - Office 365 - TI", "Confederacao", "Correio Eletrônico", "Office 365");

        groups.add(operatorGroupControleAcessoDTO);
        groups.add(operatorGroupSuporteDTO);
        groups.add(operatorGroupConfederacaoDTO);
        return groups;
    }

    @Override
    public OperationType getOperation() {
        return OperationType.ADMISSAO;
    }

    @Override
    public String getBriefDescription() {
        return "CSC-RH - Aviso de Desligamento";
    }

    @Override
    public String getRequest() {
        StringBuilder chamado = new StringBuilder();
        chamado.append("CSC-RH -  Aviso de Desligamento")
                .append("<br><br>")
                .append("O colaborador(a) " + funcionario.getNomeCompleto() + " não fará mais parte do quadro de colaboradores.<br><br>")
                .append("- Solicitamos o cancelamento da conta de e-mail")
                .append("<br>")
                .append("- Excluir o colaborador dos grupos de e-mail que o mesmo faz parte")
                .append("<br><br>");
        if (funcionario.getCooperativa() != null) {
            chamado.append("EMPRESA : " + funcionario.getCooperativa().getCooperativa() + " - " + funcionario.getCooperativa().getNome() + "<br>")
                    .append("CENTRO DE CUSTO : " + funcionario.getCooperativa().getCodigoFilial() + " - " + funcionario.getCooperativa().getSiglaFilial() + "<br>");
        }
        if (funcionario.getFuncao() != null) {
            chamado.append("CARGO: " + funcionario.getFuncao().getCodigo() + " - " + funcionario.getFuncao().getDescricao() + "<br>");
        }
        chamado.append("DATA DESLIGAMENTO : " + funcionario.getDataDesligamento() + " - HORA DESLIGAMENTO: " + funcionario.getHoraDesligamento() + "<br>")
                .append("CPF : " + funcionario.getCpf() + "<br>");

        if (funcionario.getEmail() != null && !funcionario.getEmail().equalsIgnoreCase("ignore")) {
            chamado.append("E-MAIL : " + funcionario.getEmail() + "<br>");
        }
        chamado.append("Atenciosamente <br> ");
        return chamado.toString();
    }

}
