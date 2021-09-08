package br.com.unicoob.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AfastamentoDTO {
    private Date data;
    private Date dataRetorno;
    private String codigo;
    private TipoAfastamentoDTO tipoAfastamentoDTO;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(Date dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public TipoAfastamentoDTO getTipoAfastamentoDTO() {
        return tipoAfastamentoDTO;
    }

    public void setTipoAfastamentoDTO(TipoAfastamentoDTO tipoAfastamentoDTO) {
        this.tipoAfastamentoDTO = tipoAfastamentoDTO;
    }
}