package br.com.ibm.model;

import javax.persistence.*;

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
@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@JsonProperty("cpf_cliente")
  @Column(name = "cpf")
	private String cpf;

	@JsonProperty("nome_cliente")
  @Column(name = "nome")
	private String nome;

  @JsonProperty("data_nascimento")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT-3")
  @Column(name = "dataNasc")
	private Date dataNasc;

  @JsonProperty("telefone_cliente")
	@Column(name = "telefone")
	private String telefone;

  @JsonProperty("email_cliente")
	@Column(name = "email")
	private String email;

	@JsonProperty("numero_conta")
  @Column(name = "conta")
	private Long conta;

}
