package com.deveficiente.saascursoonline.retornopaypal;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class RetornoPaypalRequest {
	
	@Min(0)
	@Max(1)
	private int status;
	@NotBlank
	private String codigoTx;
	@NotBlank
	private String codigoApp;
	@NotNull 
	@Positive
	private BigDecimal valor;
	
	public RetornoPaypalRequest(@Min(0) @Max(1) int status, @NotBlank String codigoTx, @NotBlank String codigoApp,
			@NotNull @Positive BigDecimal valor) {
		super();
		this.status = status;
		this.codigoTx = codigoTx;
		this.codigoApp = codigoApp;
		this.valor = valor;
	}
	
	
	
}
