package com.deveficiente.saascursoonline.novacompra;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class CompraRequest {

	@NotBlank
	private String nome;
	@NotBlank
	@Email
	private String email;
	@NotNull
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	@NotBlank
	private String celular;
	@NotBlank
	private String nomeNf;
	@NotBlank
	private String endereco;
	@NotBlank
	private String bairro;
	@NotBlank
	private String cidade;
	@NotNull
	private TipoPlano tipoPlano;
	@NotBlank
	private String documento;

	public CompraRequest(@NotBlank String nome, @NotBlank @Email String email, @NotNull LocalDate dataNascimento,
			@NotBlank String celular, @NotBlank String nomeNf, @NotBlank String endereco, @NotBlank String bairro,
			@NotBlank String cidade, @NotNull TipoPlano tipoPlano, @NotBlank String documento) {
		super();
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.celular = celular;
		this.nomeNf = nomeNf;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.tipoPlano = tipoPlano;
		this.documento = documento;
	}

}
