package br.com.unicoob.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CooperativaDTO {
    private Integer cooperativa;
    private String nome;
    private String siglaFilial;
    private String codigoFilial;

    public Integer getCooperativa() {
        return cooperativa;
    }

    public void setCooperativa(Integer cooperativa) {
        this.cooperativa = cooperativa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSiglaFilial() {
        return siglaFilial;
    }

    public void setSiglaFilial(String siglaFilial) {
        this.siglaFilial = siglaFilial;
    }

    public String getCodigoFilial() {
        return codigoFilial;
    }

    public void setCodigoFilial(String codigoFilial) {
        this.codigoFilial = codigoFilial;
    }
}