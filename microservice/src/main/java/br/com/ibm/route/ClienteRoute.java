package br.com.ibm.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ibm.domain.ClienteCriado;
import br.com.ibm.processors.ConsultaClienteEntradaProcessor;
import br.com.ibm.processors.ConsultaClienteSaidaProcessor;

@Component
public class ClienteRoute extends RouteBuilder {

	public static String DIRECT_CLIENTE_ROUTE = "direct: cliente-route";
	public static String ID_CLIENTE_ROUTE = "cliente-route";
	public static String CLIENTE_ROUTE_API = "https://cliente-api-microservice.herokuapp.com/cliente/consulta";

	private ConsultaClienteSaidaProcessor consultaClienteSaidaProcessor;
	private ConsultaClienteEntradaProcessor consultaClienteEntradaProcessor;

	@Autowired
	public ClienteRoute(ConsultaClienteSaidaProcessor consultaClienteSaidaProcessor,
			ConsultaClienteEntradaProcessor consultaClienteEntradaProcessor) {
		this.consultaClienteSaidaProcessor = consultaClienteSaidaProcessor;
		this.consultaClienteEntradaProcessor = consultaClienteEntradaProcessor;
	}

	@Override
	public void configure() throws Exception {

		from(DIRECT_CLIENTE_ROUTE)
			.id(ID_CLIENTE_ROUTE)
				.process(consultaClienteEntradaProcessor)
			.to(CLIENTE_ROUTE_API)
			.unmarshal().json(JsonLibrary.Jackson, ClienteCriado.class)
				.process(consultaClienteSaidaProcessor)
		.end();

	}


}
