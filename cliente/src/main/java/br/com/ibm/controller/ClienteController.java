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
import br.com.ibm.model.Cliente;
import br.com.ibm.service.ClienteService;

@RestController
@RequestMapping("/")
public class ClienteController {

	private ClienteService cs;

  @Autowired
  public ClienteController(ClienteService cs) {
    this.cs = cs;
  }

  @PostMapping("cliente/novo")
	public ResponseEntity<Object> criaNovoCliente(@RequestBody Cliente cliente) {
		try {
			cs.criaCliente(cliente);
			return ResponseEntity.ok("Cliente inserido com exito");
		}catch (InternalException ie) {
			return ResponseEntity.badRequest().body(new Resposta(ie.getCode(), ie.getMessage(), null));
		}
	}

	@PostMapping("cliente/altera")
	public ResponseEntity<Object> alterarClienteCpf(@RequestBody Cliente cliente) {
		try {
			cs.alterarCliente(cliente);
			return ResponseEntity.ok("Cliente alterado com exito");
		}catch (InternalException ie) {
			return ResponseEntity.badRequest().body(new Resposta(ie.getCode(), ie.getMessage(), null));
		}
	}

	@GetMapping("cliente/consulta")
	public List<Cliente> consultarCliente(){
		return cs.consultaCliente();
	}

	@GetMapping("cliente/consulta/{cpf}")
  public ResponseEntity<Object> consultaClienteCpf(@PathVariable(value = "cpf") String cpf) {
    try {
      return ResponseEntity.ok(cs.consultaClienteCpf(cpf));
    }catch(ObjetoInexistenteException e) {
      return ResponseEntity.badRequest().body(new Resposta(e.getCode(), e.getLocalizedMessage(), null));
    }
  }

  @GetMapping("cliente/consulta/{cpf}/{conta}")
  public ResponseEntity<Object> consultaClienteCpfAndConta(@PathVariable(value = "cpf") String cpf, @PathVariable(value = "conta") Long conta) {
    try {
      return ResponseEntity.ok(cs.consultaClienteCpfAndConta(cpf, conta));
    }catch(ObjetoInexistenteException e) {
      return ResponseEntity.badRequest().body(new Resposta(e.getCode(), e.getLocalizedMessage(), null));
    }
  }

	@DeleteMapping("cliente/deleta/{cpf}")
	public ResponseEntity<Object> deletarClienteCpf(@PathVariable(value = "cpf") String cpf) {
		try {
			cs.deletaCliente(cpf);
			return ResponseEntity.ok("Cliente de id "+ cpf + " foi deletado com exito.");
		}catch(ObjetoInexistenteException e) {
			return ResponseEntity.badRequest().body(new Resposta(e.getCode(), e.getLocalizedMessage(), null));
		}
	}

}
