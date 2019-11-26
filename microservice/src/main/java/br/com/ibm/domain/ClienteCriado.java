package br.com.ibm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteCriado {

  @JsonProperty("cpf_cliente")
	private String  cpf;

  @JsonProperty("nome_cliente")
	private String nome;

  @JsonProperty("data_nascimento")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT-3")
	private Date dtNasc;

  @JsonProperty("telefone_cliente")
	private String telefone;

  @JsonProperty("email_cliente")
	private String email;

  @JsonProperty("numero_conta")
  private Long conta;
}
