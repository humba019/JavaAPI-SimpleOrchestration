package br.com.ibm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.ObjenesisException;
import org.springframework.stereotype.Service;

import br.com.ibm.exception.ObjetoInexistenteException;
import br.com.ibm.model.Contrato;
import br.com.ibm.repository.ContratoRepository;
import br.com.ibm.service.ContratoService;

@Service
public class ContratoServiceImpl implements ContratoService{

	private ContratoRepository cr;

  @Autowired
  public ContratoServiceImpl(ContratoRepository cr) {
    this.cr = cr;
  }

  @Override
	public Contrato criarContrato(Contrato contrato) {
		return cr.save(contrato);
	}

	@Override
	public List<Contrato> consultarContrato() {
    List<Contrato> contratoIn = cr.findAll();
    if (contratoIn.size()>0) {
      return contratoIn;
    }
    throw new ObjetoInexistenteException("Nenhum contrato inserido");
	}

	@Override
	public List<Contrato> consultarContratoNum(Long numContrato) {
		List<Contrato> c = cr.findByNumContrato(numContrato);

		if(c.equals(null))
			throw new ObjetoInexistenteException("Nao ha contratos vinculados ao numero " + numContrato);

		return c;
	}

	@Override
	public Contrato deletarContrato(Long numContrato) {
		List<Contrato> c = cr.findByNumContrato(numContrato);

		if(c.size() == 0)
			throw new ObjetoInexistenteException("O contrato de id "+numContrato+" nao existe e nao foi deleta.");
		cr.delete(c.get(0));
		return c.get(0);
	}

  @Override
  public List<Contrato> consultaContratoStatus(String status) {
    List<Contrato> contratoIn = cr.findAllByStatus(status);
    if (contratoIn.size()>0) {
      return contratoIn;
    }
    throw new ObjetoInexistenteException("nenhum status "+status);
  }

  @Override
  public List<Contrato> consultaContratoCpfClienteStatus(String cpfCliente, String status) {
    List<Contrato> contratoIn = cr.findAllByCpfClienteAndStatus(cpfCliente, status);
    if (contratoIn.size()>0){
      return contratoIn;
    }
    throw new ObjetoInexistenteException("nenhum contrato encontrado");
  }

// Via @Query
//	@Override
//	public void alterarContrato(Long nContrato, Contrato contrato) {
//		Optional<Contrato> c = cr.findById(nContrato);
//
//		if(!c.isPresent())
//			throw new ObjetoInexistenteException("O cotrato de id "+nContrato+" nao existe e nao foi alterado.");
//
//		cr.alterarContrato(contrato.getCpfCliente(), contrato.getStatus(), contrato.getDtIni(), contrato.getDtFim(),contrato.getValor(), nContrato);
//	}

	@Override
	public List<Contrato> consultarContratoCpfCliente(String cpfCliente) {
		List<Contrato> c = cr.findByCpfCliente(cpfCliente);

		if(c.isEmpty())
			throw new ObjetoInexistenteException("Nao ha contratos vinculados ao cpf " + cpfCliente);

		return c;
	}

	@Override
	public List<Contrato> consultarContratoNumContratoAndCpfCliente(Long numContrato, String cpfCliente) {
		List<Contrato> c = cr.findByNumContratoAndCpfCliente(numContrato, cpfCliente);

		if(c.isEmpty())
			throw new ObjetoInexistenteException("Nao ha contratos vinculados ao cpf " +cpfCliente+ " e numero " + numContrato);

		return c;
	}

	@Override
	public void alterarContrato(Contrato contrato) {

		List<Contrato> c = cr.findByNumContrato(contrato.getNumContrato());

		if (c.size()==0)
			throw new ObjetoInexistenteException("Contrato de numero "+contrato.getNumContrato()+" nao encontrado e nao alterado.");

		cr.alterarContrato(contrato.getCpfCliente(), contrato.getStatus(), contrato.getDtIni(), contrato.getDtFim(), contrato.getValor(), contrato.getNumContrato());

	}





}
