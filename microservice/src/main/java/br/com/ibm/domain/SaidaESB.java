package br.com.ibm.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaidaESB {

	@JsonProperty("cpf_cliente")
	private String cpf;

	@JsonProperty("nome_cliente")
  private String nome;

  @JsonProperty("numero_conta")
  private Long conta;

  @JsonProperty("contratos")
  private List<Contrato> contrato;

}
