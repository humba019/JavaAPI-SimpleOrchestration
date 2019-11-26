package br.com.ibm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ibm.model.Cliente;

public interface ClienteService {

	public Cliente criaCliente(Cliente cliente);

	public Cliente deletaCliente(String cpf);

	public Cliente consultaClienteCpf(String cpf);

	public List<Cliente> consultaCliente();

	public Cliente alterarCliente(Cliente cliente);

	public Optional<Cliente> consultaClienteCpfAndConta(String cpf, Long conta);
}
