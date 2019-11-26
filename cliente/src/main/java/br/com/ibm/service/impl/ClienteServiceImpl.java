package br.com.ibm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ibm.exception.ObjetoInexistenteException;
import br.com.ibm.model.Cliente;
import br.com.ibm.repository.ClienteRepository;
import br.com.ibm.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	private ClienteRepository cr;

  @Autowired
  public ClienteServiceImpl(ClienteRepository cr) {
    this.cr = cr;
  }

  @Override
	public Cliente criaCliente(Cliente cliente) {
		return cr.save(cliente);
	}

	@Override
	public Cliente deletaCliente(String cpf) {
		Optional<Cliente> c = cr.findById(cpf);

		if(!c.isPresent())
			throw new ObjetoInexistenteException("O cliente de id "+cpf+" nao encontrado e nao excluido.");

		cr.deleteById(cpf);
		return c.get();
	}

	@Override
	public Cliente consultaClienteCpf(String cpf) {
		Optional<Cliente> c = cr.findById(cpf);

		if(!c.isPresent())
			throw new ObjetoInexistenteException("O cliente de id "+ cpf +" nao encontrado.");

		return c.get();
	}

	@Override
	public Cliente alterarCliente(Cliente cliente) {
		Optional<Cliente> c = cr.findById(cliente.getCpf());

		if(!c.isPresent())
			throw new ObjetoInexistenteException("O cliente de id "+cliente.getCpf()+" nao encontrado e nao alterado.");

		cr.alterarCliente(cliente.getCpf(), cliente.getNome(), cliente.getDataNasc(), cliente.getTelefone(), cliente.getEmail());

		return c.get();
	}

  @Override
  public Optional<Cliente> consultaClienteCpfAndConta(String cpf, Long conta) {
	  Optional<Cliente> clienteIn = cr.findByCpfAndAndConta(cpf, conta);
	  if (clienteIn.isPresent()){
	      return clienteIn;
    }
	  throw new ObjetoInexistenteException("O cpf ou conta nao existem");
  }

  @Override
	public List<Cliente> consultaCliente() {
		return cr.findAll();
	}



}
