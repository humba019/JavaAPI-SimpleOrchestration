package br.com.ibm.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import br.com.ibm.domain.ClienteCriado;

@Component
public class ConsultaClienteSaidaProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {

		ClienteCriado clienteCriado =  exchange.getIn().getBody(ClienteCriado.class);
		exchange.setProperty("nome_cliente", clienteCriado.getNome());
		exchange.setProperty("cpf_cliente", clienteCriado.getCpf());
		exchange.setProperty("numero_conta", clienteCriado.getConta());
		exchange.getOut().setBody(clienteCriado);

	}

}
