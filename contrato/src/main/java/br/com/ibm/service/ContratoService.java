package br.com.ibm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ibm.model.Contrato;

public interface ContratoService {

	public Contrato criarContrato(Contrato contrato);

	public List<Contrato> consultarContrato();

	public List<Contrato> consultarContratoNum(Long numContrato);

	public List<Contrato> consultarContratoCpfCliente(String cpfCliente);

	public List<Contrato> consultarContratoNumContratoAndCpfCliente(Long numContrato, String cpfCliente);

	public Contrato deletarContrato(Long nContrato);

	public List<Contrato> consultaContratoStatus(String status);

  public List<Contrato> consultaContratoCpfClienteStatus(String cpfCliente, String status);

	//Via @Query
	public void alterarContrato(Contrato contrato);

}
