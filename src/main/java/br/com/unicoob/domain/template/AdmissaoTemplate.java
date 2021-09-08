package br.com.unicoob.domain.template;

import br.com.unicoob.domain.dto.FuncionarioApiDTO;
import br.com.unicoob.domain.dto.OperatorGroupDTO;
import br.com.unicoob.domain.interfaces.IChamados;
import br.com.unicoob.domain.type.OperationType;

import java.util.ArrayList;
import java.util.List;

public class AdmissaoTemplate implements IChamados {

    FuncionarioApiDTO funcionario;


    public AdmissaoTemplate(FuncionarioApiDTO funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public List<OperatorGroupDTO> getOperatorGroups() {
        ArrayList<OperatorGroupDTO> groups = new ArrayList<>();
        OperatorGroupDTO operatorGroupControleAcessoDTO = new OperatorGroupDTO("2009 - Controle de Acesso - Monitoria e Supervisao", "Controle de Acesso", "2009. Tecnologia - Acessos", "Novo Funcionário");
        OperatorGroupDTO operatorGroupSuporteDTO = new OperatorGroupDTO("2009 - TI - Suporte", "Suporte", "2009. Tecnologia - Acessos", "Novo Funcionário");

        groups.add(operatorGroupControleAcessoDTO);
        groups.add(operatorGroupSuporteDTO);
        return groups;
    }

    @Override
    public OperationType getOperation() {
        return OperationType.ADMISSAO;
    }

    @Override
    public String getBriefDescription() {
        return "CSC-RH - Aviso de Admissão";
    }

    @Override
    public String getRequest() {
        StringBuilder chamado = new StringBuilder();
        chamado.append("CSC-RH -  Aviso de Admissão")
                .append("<br><br>")
                .append("O colaborador(a) " + funcionario.getNomeCompleto() + " foi ADMITIDO :<br><br>")
                .append("Cadastrar o colaborador abaixo no Top Desk (Central de Suporte e Servicos do Sicoob) para abertura de chamados.")
                .append("<br><br>");
        if (funcionario.getCooperativa() != null) {
            chamado.append("EMPRESA : " + funcionario.getCooperativa().getCooperativa() + " - " + funcionario.getCooperativa().getNome() + "<br>")
                    .append("CENTRO DE CUSTO : " + funcionario.getCooperativa().getCodigoFilial() + " - " + funcionario.getCooperativa().getSiglaFilial() + "<br>");
        }
        if (funcionario.getFuncao() != null) {
            chamado.append("CARGO: " + funcionario.getFuncao().getCodigo() + " - " + funcionario.getFuncao().getDescricao() + "<br>");
        }
        chamado.append("DATA DA ADMISSÃO : " + funcionario.getDataAdmissao() + "<br>")
                .append("CPF : " + funcionario.getCpf() + "<br>");

        if (funcionario.getEmail() != null && !funcionario.getEmail().equalsIgnoreCase("ignore")) {
            chamado.append("E-MAIL : " + funcionario.getEmail() + "<br>");
        }
        if (funcionario.getLider() != null) {
            chamado.append("GESTOR : " + funcionario.getLider().getNome() + "<br><br>");
        }
        chamado.append("Atenciosamente <br> ");
        return chamado.toString();
    }

}
