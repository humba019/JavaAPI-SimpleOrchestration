package br.com.ibm.processors;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import br.com.ibm.domain.Contrato;
import br.com.ibm.domain.ContratoCriado;
import br.com.ibm.domain.SaidaESB;

@Component
public class ConsultaEsbSaidaProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		SaidaESB saidaESB = new SaidaESB();

		List<ContratoCriado> listaContratoCriado = (List<ContratoCriado>) exchange.getIn().getBody();
		String nomeCliente = exchange.getProperty("nome_cliente", String.class);
		Long  numeroConta = exchange.getProperty("numero_conta", Long.class);
		String cpf = listaContratoCriado.get(0).getCpfCliente();

		List<Contrato> listaContrato = new ArrayList<>();

      for (ContratoCriado contratoCriado : listaContratoCriado) {

        Contrato c = new Contrato();
        c.setNumero(contratoCriado.getNumeroContrato());
        c.setValor(contratoCriado.getValor());
        c.setStatus(contratoCriado.getStatus());

        listaContrato.add(c);

      }

		saidaESB.setCpf(cpf);
		saidaESB.setNome(nomeCliente);
		saidaESB.setConta(numeroConta);
		saidaESB.setContrato(listaContrato);

		exchange.getOut().setBody(saidaESB);

	}

}
