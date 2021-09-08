package br.com.unicoob.routes;

import br.com.unicoob.domain.dto.FuncionarioApiDTO;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.springframework.stereotype.Component;


@Component
public class DemitidosRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("quartz://simpleTimerDemitidosRoute?cron=0+10,40+6-19+?+*+MON-FRI")
                .routeId("DemitidosRoute")
                .log("DemitidosRoute iniciado")
                .bean("configurarParametrosProcessorDesligados")
                .to("{{rh.url.desligados}}")
                .choice()
                .when(body().isNotNull())
                .unmarshal(new ListJacksonDataFormat(FuncionarioApiDTO.class))
                .split(simple("${body}"))
                .bean("chamadoDemissaoProcessor")
                .end();

    }
}