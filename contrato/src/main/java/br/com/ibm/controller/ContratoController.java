package br.com.ibm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ibm.exception.InternalException;
import br.com.ibm.exception.ObjetoInexistenteException;
import br.com.ibm.exception.Resposta;
import br.com.ibm.model.Contrato;
import br.com.ibm.service.ContratoService;

@RestController
@RequestMapping("/")
public class ContratoController {

	private ContratoService cs;

  @Autowired
  public ContratoController(ContratoService cs) {
    this.cs = cs;
  }

  @PostMapping("contrato/novo")
	public ResponseEntity<Object> criaContrato(@RequestBody Contrato contrato) {
		try {
			cs.criarContrato(contrato);
			return ResponseEntity.ok("Contrato inserido com exito!");

		}catch(InternalException ie) {

			return ResponseEntity.badRequest().body(new Resposta(ie.getCode(), ie.getMessage(), null));

		}
	}

	@PostMapping("contrato/altera")
	public ResponseEntity<Object> alteraContrato(@RequestBody Contrato contrato) {
		try {
			cs.alterarContrato(contrato);
			return ResponseEntity.ok("O contrato de id "+contrato.getNumContrato()+" foi alterado");
		}catch(ObjetoInexistenteException e) {
			return ResponseEntity.badRequest().body(new Resposta(e.getCode(), e.getLocalizedMessage(), null));
		}
	}

	@GetMapping("contrato/consulta/numero/{numContrato}")
	public ResponseEntity<Object> consultaContratoNumero(@PathVariable(value = "numContrato") Long numContrato) {
		try {

			return ResponseEntity.ok(cs.consultarContratoNum(numContrato));

		}catch(ObjetoInexistenteException e) {

			return ResponseEntity.badRequest().body(new Resposta(e.getCode(), e.getLocalizedMessage(), null));

		}
	}

	@GetMapping("contrato/consulta/{cpf}")
	public ResponseEntity<Object> consultaConsultaCpfCliente(@PathVariable(value = "cpf") String cpfCliente) {
		try {

			return ResponseEntity.ok(cs.consultarContratoCpfCliente(cpfCliente));

		}catch(ObjetoInexistenteException e) {

			return ResponseEntity.badRequest().body(new Resposta(e.getCode(), e.getLocalizedMessage(), null));

		}
	}

//  @GetMapping("contrato/consulta/{status}")
//  public ResponseEntity<Object> consultaConsultaStatus(@PathVariable(value = "status") String status) {
//    try {
//
//      return ResponseEntity.ok(cs.consultaContratoStatus(status));
//
//    }catch(ObjetoInexistenteException e) {
//
//      return ResponseEntity.badRequest().body(new Resposta(e.getCode(), e.getLocalizedMessage(), null));
//
//    }
//  }

  @GetMapping("contrato/consulta/{cpfCliente}/{status}")
  public ResponseEntity<Object> consultaConsultaStatus(@PathVariable(value = "cpfCliente") String cpfCliente, @PathVariable(value = "status") String status) {
    try {

      return ResponseEntity.ok(cs.consultaContratoCpfClienteStatus(cpfCliente, status));

    }catch(ObjetoInexistenteException e) {

      return ResponseEntity.badRequest().body(new Resposta(e.getCode(), e.getLocalizedMessage(), null));

    }
  }

	@GetMapping("contrato/consulta/numero-cpf/{numContrato}/{cpfCliente}")
	public ResponseEntity<Object> consultaConsultaNContratoAndCpfCliente(@PathVariable(value = "numContrato") Long numContrato, @PathVariable(value = "cpfCliente") String cpfCliente) {
		try {

			return ResponseEntity.ok(cs.consultarContratoNumContratoAndCpfCliente(numContrato, cpfCliente));

		}catch(ObjetoInexistenteException e) {

			return ResponseEntity.badRequest().body(new Resposta(e.getCode(), e.getLocalizedMessage(), null));

		}
	}

	@GetMapping("contrato/consulta")
	public List<Contrato> consultaContrato(){
		return cs.consultarContrato();
	}

	@DeleteMapping("contrato/deleta/{numContrato}")
	public ResponseEntity<Object> deletaContrato(@PathVariable(value = "numContrato") Long numContrato) {
		try {

			cs.deletarContrato(numContrato);
			return ResponseEntity.ok("O contrato de id "+numContrato+" foi removido.");

		}catch(ObjetoInexistenteException e) {
			return ResponseEntity.badRequest().body(new Resposta(e.getCode(), e.getLocalizedMessage(), null));
		}
	}

}
