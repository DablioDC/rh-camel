package br.com.unicoob.routes;

import br.com.unicoob.domain.dto.FuncionarioApiDTO;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.springframework.stereotype.Component;


@Component
public class AdmitidosRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

           from("quartz://simpleTimerAdmitidosRoute?cron=0+0,30+6-19+?+*+MON-FRI")
                .routeId("AdmitidosRoute")
                .log("AdmitidosRoute iniciado")
                .bean("configurarParametrosProcessorAdmissao")
                .to("{{rh.url.ativos}}")
                   .choice()
                   .when(body().isNotNull())
                        .unmarshal(new ListJacksonDataFormat(FuncionarioApiDTO.class))
                        .split(simple("${body}"))
                        .bean("chamadoAdmissaoProcessor")
                   .end();
    }
}
