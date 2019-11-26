package br.com.ibm.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ibm.model.Cliente;

import java.util.Date;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{

	@Transactional
	@Modifying
	@Query("UPDATE Cliente c SET c.cpf = :cpf, c.nome = :nome, c.dataNasc = :dataNasc, c.telefone = :telefone, c.email = :email WHERE c.cpf = :cpf")
	public void alterarCliente(@Param("cpf") String cpf, @Param("nome") String nome, @Param("dataNasc") Date dataNasc, @Param("telefone") String telefone, @Param("email") String email);

	public Optional<Cliente> findByCpfAndAndConta(String cpf, Long conta);

}
