package br.com.ibm.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.http.HttpMethods;
import org.springframework.stereotype.Component;

@Component
public class ConsultaClienteEntradaProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		exchange.getOut().setHeader(Exchange.HTTP_METHOD, HttpMethods.GET);
		exchange.getOut().setHeader(Exchange.HTTP_PATH, exchange.getIn().getHeader("cpf"));
		exchange.getOut().setBody("");
	}

}
