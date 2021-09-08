package br.com.unicoob.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FuncionarioApiDTO {
    private String nomeCompleto;
    private String matricula;
    @JsonProperty("cooperativa")
    private CooperativaDTO cooperativa;
    private String cpf;
    @JsonProperty("funcao")
    private FuncaoDTO funcao;
    @JsonProperty("lider")
    private LiderDTO lider;
    @JsonProperty("situacao")
    private SituacaoDTO situacao;
    private String datahora;
    private String usuario;
    private String email;
    private AfastamentoDTO afastamento;
    @JsonProperty("dataAdmissao")
    private String dataAdmissao;
    @JsonProperty("dataDesligamento")
    private String dataDesligamento;
    @JsonProperty("horaDesligamento")
    private String horaDesligamento;
    private String loginAd;

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public CooperativaDTO getCooperativa() {
        return cooperativa;
    }

    public void setCooperativa(CooperativaDTO cooperativa) {
        this.cooperativa = cooperativa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public FuncaoDTO getFuncao() {
        return funcao;
    }

    public void setFuncao(FuncaoDTO funcao) {
        this.funcao = funcao;
    }

    public SituacaoDTO getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoDTO situacao) {
        this.situacao = situacao;
    }

    public String getDatahora() {
        return datahora;
    }

    public void setDatahora(String datahora) {
        this.datahora = datahora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AfastamentoDTO getAfastamento() {
        return afastamento;
    }

    public void setAfastamento(AfastamentoDTO afastamento) {
        this.afastamento = afastamento;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public String getDataDesligamento() {
        return dataDesligamento;
    }

    public String getHoraDesligamento() {
        return horaDesligamento;
    }

    public void setHoraDesligamento(String horaDesligamento) {
        this.horaDesligamento = horaDesligamento;
    }

    public void setDataDesligamento(String dataDesligamento) {
        this.dataDesligamento = dataDesligamento;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getLoginAd() {
        return loginAd;
    }

    public void setLoginAd(String loginAd) {
        this.loginAd = loginAd;
    }

    public LiderDTO getLider() {
        return lider;
    }

    public void setLider(LiderDTO lider) {
        this.lider = lider;
    }

    @Override
    public String toString() {
        return "FuncionarioApiDTO{" +
                "nomeCompleto='" + nomeCompleto + '\'' +
                ", matricula='" + matricula + '\'' +
                ", cooperativa=" + cooperativa.getCooperativa() +
                '}';
    }
}