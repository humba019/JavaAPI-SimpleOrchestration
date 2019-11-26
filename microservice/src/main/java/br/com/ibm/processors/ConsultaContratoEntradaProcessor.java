package br.com.ibm.processors;

import br.com.ibm.domain.Contrato;
import br.com.ibm.domain.ContratoCriado;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.http.HttpMethods;
import org.springframework.stereotype.Component;

import br.com.ibm.domain.ClienteCriado;

@Component
public class ConsultaContratoEntradaProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {

		ClienteCriado clienteCriado = exchange.getIn().getBody(ClienteCriado.class);

		exchange.getOut().setHeader(Exchange.HTTP_METHOD, HttpMethods.GET);
		exchange.getOut().setHeader(Exchange.HTTP_PATH, clienteCriado.getCpf());
		exchange.getOut().setBody("");
	}

}
