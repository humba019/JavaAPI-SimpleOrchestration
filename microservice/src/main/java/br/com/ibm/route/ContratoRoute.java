package br.com.ibm.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ibm.domain.ContratoCriado;
import br.com.ibm.processors.ConsultaContratoEntradaProcessor;
import br.com.ibm.processors.ConsultaContratoSaidaProcessor;

@Component
public class ContratoRoute extends RouteBuilder{

	public static String DIRECT_CONTRATO_ROUTE = "direct: contrato-route";
	public static String ID_CONTRATO_ROUTE = "contrato-route";
	public static String CONTRATO_ROUTE_API = "https://contrato-api-microservice.herokuapp.com/contrato/consulta";

	private ConsultaContratoSaidaProcessor consultaContratoSaidaProcessor;
	private ConsultaContratoEntradaProcessor consultaContratoEntradaProcessor;

	@Autowired
	public ContratoRoute(ConsultaContratoSaidaProcessor consultaContratoSaidaProcessor,
			ConsultaContratoEntradaProcessor consultaContratoEntradaProcessor) {
		this.consultaContratoSaidaProcessor = consultaContratoSaidaProcessor;
		this.consultaContratoEntradaProcessor = consultaContratoEntradaProcessor;
	}



	@Override
	public void configure() throws Exception {
		JacksonDataFormat format = new ListJacksonDataFormat(ContratoCriado.class);

		from(DIRECT_CONTRATO_ROUTE)
			.id(ID_CONTRATO_ROUTE)
				.process(consultaContratoEntradaProcessor)
			.to(CONTRATO_ROUTE_API)
			.unmarshal(format)
				.process(consultaContratoSaidaProcessor)
			.end();

	}


}
