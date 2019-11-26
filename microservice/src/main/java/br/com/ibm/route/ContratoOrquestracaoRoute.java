package br.com.ibm.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ibm.processors.ConsultaEsbSaidaProcessor;

@Component
public class ContratoOrquestracaoRoute extends RouteBuilder {
	
	public static String DIRECT_ROUTE_CONTRATO_ORQUESTRACAO = "direct: route-contrato-orquestracao";
	public static String ID_ROUTE_CONTRATO_ORQUESTRACAO = "route-contrato-orquestracao";
	
	ConsultaEsbSaidaProcessor consultaEsbSaidaProcessor;
	
	@Autowired
	public ContratoOrquestracaoRoute(ConsultaEsbSaidaProcessor consultaEsbSaidaProcessor) {
		this.consultaEsbSaidaProcessor = consultaEsbSaidaProcessor;
	}

	@Override
	public void configure() throws Exception {

		from(DIRECT_ROUTE_CONTRATO_ORQUESTRACAO)
			.id(ID_ROUTE_CONTRATO_ORQUESTRACAO)
				.to(ClienteRoute.DIRECT_CLIENTE_ROUTE)
				.to(ContratoRoute.DIRECT_CONTRATO_ROUTE)
			.process(consultaEsbSaidaProcessor)
		.end();		
				
	}
	
	
	
	
}
