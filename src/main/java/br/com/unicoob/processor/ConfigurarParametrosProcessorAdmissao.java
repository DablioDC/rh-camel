package br.com.unicoob.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class ConfigurarParametrosProcessorAdmissao implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        Calendar calendar = Calendar.getInstance();
        Date diaAtual = calendar.getTime();
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
        exchange.getIn().setHeader(Exchange.HTTP_QUERY, "dtAdmissaoInicial="+dt1.format(diaAtual));
    }

}

