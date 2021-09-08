package br.com.unicoob.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class ConfigurarParametrosProcessorDesligados implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        LocalDate dataInicio = LocalDate.now().minusDays(10);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        exchange.getIn().setHeader(Exchange.HTTP_QUERY, "dtDemissaoInicial="+dataInicio.format(formatter));
    }

}

