package com.deveficiente.saascursoonline.novacompra;

import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String nome;
	private @NotBlank @Email String email;
	private @NotNull @Idade(18) LocalDate dataNascimento;
	private @NotBlank String celular;
	private @NotBlank String nomeNf;
	private @NotBlank String endereco;
	private @NotBlank String bairro;
	private @NotBlank String cidade;
	private @NotNull TipoPlano tipoPlano;
	private @NotBlank @Documento String documento;
	private String codigo = UUID.randomUUID().toString();

	public Compra(@NotBlank String nome, @NotBlank @Email String email, @NotNull @Idade(18) LocalDate dataNascimento,
			@NotBlank String celular, @NotBlank String nomeNf, @NotBlank String endereco, @NotBlank String bairro,
			@NotBlank String cidade, @NotNull TipoPlano tipoPlano, @NotBlank @Documento String documento) {
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
		// TODO Auto-generated constructor stub
	}

	public URI geraURL(UriComponentsBuilder uriComponentsBuilder) {
		return uriComponentsBuilder.fromHttpUrl("http://gateway.paypal.com/payment?customId={codigoNaoFacilmenteEntendivel}&payment={valorDoPlanoEscolhido").build(this.codigo, this.tipoPlano.getValor());
	}

	public String getCodigo() {
		 return this.codigo;
	}
}
