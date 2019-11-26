package br.com.ibm.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ibm.model.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {

	@Transactional
	@Modifying
	@Query("UPDATE Contrato c SET c.cpfCliente = :cpfCliente, c.status = :status, c.dtIni = :dtIni, c.dtFim = :dtFim, c.valor = :valor WHERE c.numContrato = :numContrato")
	public void alterarContrato(@Param("cpfCliente") String cpfCliente, @Param("status") String status, @Param("dtIni") Date dtIni, @Param("dtFim") Date dtFim, @Param("valor") Double valor, @Param("numContrato") Long numContrato);

	public List<Contrato> findByNumContrato(Long numContrato);

	public List<Contrato> findAllByCpfClienteAndStatus(String cpfClient, String status);

	public List<Contrato> findAllByStatus(String status);

	public List<Contrato> findByCpfCliente(String cpfCliente);

	public List<Contrato> findByNumContratoAndCpfCliente(Long numContrato, String cpfCliente);
}
