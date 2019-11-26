package br.com.ibm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NegativeOrZero;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContratoCriado{

	@JsonProperty("id")
	private Long id;

	@JsonProperty("cpf_cliente")
	private String cpfCliente;

	@JsonProperty("numero_contrato")
	private Long numeroContrato;

	@JsonProperty("valor")
	private Double valor;

	@JsonProperty("status")
	private String status;

	@JsonProperty("data_inicio")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT-3")
	private Date dataInicio;

	@JsonProperty("data_fim")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT-3")
	private Date dataFim;

}
