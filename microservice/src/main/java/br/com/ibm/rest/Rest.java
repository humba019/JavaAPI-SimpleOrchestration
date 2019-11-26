package br.com.ibm.rest;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import br.com.ibm.exceptions.ServerInterneErro;
import br.com.ibm.route.ContratoOrquestracaoRoute;

@Component
public class Rest extends RouteBuilder{
	
	public ServerInterneErro serverInterneErro;
	
	public Rest(ServerInterneErro serverInterneErro) {
		this.serverInterneErro = serverInterneErro;
	}


	@Override
	public void configure() throws Exception {
		rest("/contrato")
		.get("/define_contrato")
		.consumes("application/json")
		.produces("application/json")
			.route()
				.id("info-do-contrato")
				.description("Buscar informacoes contrato cliente")
				.doTry()
					.to(ContratoOrquestracaoRoute.DIRECT_ROUTE_CONTRATO_ORQUESTRACAO)
				.endDoTry()
				.doCatch(Exception.class)
					.process(serverInterneErro)
				.end()
		.endRest();
	}
	
	

}
