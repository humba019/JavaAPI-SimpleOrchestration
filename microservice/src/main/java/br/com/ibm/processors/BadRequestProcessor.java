package br.com.ibm.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class BadRequestProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		exchange.getOut().setHeader(Exchange.HTTP_RESPONSE_CODE, HttpStatus.BAD_REQUEST);
		exchange.getOut().setBody(exchange.getProperty(Exchange.EXCEPTION_CAUGHT).toString());
	}

	
	
}
