package br.com.ibm.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrato {

	@JsonProperty("numero_contrato")
	private Long numero;

	@JsonProperty("valor")
	private Double valor;

	@JsonProperty("status")
	private String status;

}
