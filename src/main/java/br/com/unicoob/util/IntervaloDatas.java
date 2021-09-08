package br.com.unicoob.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class IntervaloDatas {
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Date dataInicial;
    private Date dataFinal;

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }


    public String getDataFinalFormatada() {
        return format.format(dataFinal);
    }

    public String getDataInicialFormatada() {
        return format.format(dataInicial);
    }

    public String periodo() {
        return " - Data Base: " + getDataInicialFormatada() + " à " + getDataFinalFormatada();
    }


}
