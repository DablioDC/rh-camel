package br.com.unicoob.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OperatorGroupDTO {
    private String nome;
    private String nomeAbreviado;
    private String categoryName;
    private String subcategoryName;


    public OperatorGroupDTO(String nome, String nomeAbreviado, String categoryName, String subcategoryName) {
        this.nome = nome;
        this.nomeAbreviado = nomeAbreviado;
        this.categoryName = categoryName;
        this.subcategoryName = subcategoryName;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeAbreviado() {
        return nomeAbreviado;
    }

    public void setNomeAbreviado(String nomeAbreviado) {
        this.nomeAbreviado = nomeAbreviado;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }
}