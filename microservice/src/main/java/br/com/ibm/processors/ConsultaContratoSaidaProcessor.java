package br.com.ibm.processors;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import br.com.ibm.domain.ContratoCriado;

@Component
public class ConsultaContratoSaidaProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception{

		List<ContratoCriado> listaContratoCriado = (List<ContratoCriado>) exchange.getIn().getBody();

		for (ContratoCriado contratoCriado : listaContratoCriado) {

			if(contratoCriado.getCpfCliente().isEmpty())
				throw new IllegalArgumentException("Cpf do cliente nao encontrato");

			if(contratoCriado.getNumeroContrato() == null)
				throw new IllegalArgumentException("o numero do contrato nao pode ser nulo");

			if(contratoCriado.getValor() == null)
				throw new IllegalArgumentException("o valor nao pode ser nulo");

			if(contratoCriado.getStatus().isEmpty())
				throw new IllegalArgumentException("O status nao pode ser vazio");

		}

		exchange.getOut().setBody(listaContratoCriado);

	}



}
