package br.com.ibm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.asm.Advice;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contrato")
public class Contrato {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  @JsonProperty("id")
	@Column(name = "id")
	private Long id;

  @JsonProperty("numero_contrato")
	@Column(name = "numContrato")
	private Long numContrato;

  @JsonProperty("cpf_cliente")
	@Column(name = "cpfCliente")
	private String cpfCliente;

  @JsonProperty("status")
	@Column(name = "status")
	private String status;

  @JsonProperty("valor")
	@Column(name = "valor")
	private Double valor;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT-3")
  @JsonProperty("data_inicio")
	@Column(name = "dtIni")
  private Date dtIni;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT-3")
  @JsonProperty("data_fim")
  @Column(name = "dtFim")
	private Date dtFim;


}
