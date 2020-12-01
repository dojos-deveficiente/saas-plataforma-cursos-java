package com.deveficiente.saascursoonline.novacompra;

import java.math.BigDecimal;

public enum TipoPlano {
  BASICO("200.00"),
  EXPERT("400.00"),
  POWER("600.00");

  private final BigDecimal valor;

  TipoPlano(String valor) {
    this.valor = new BigDecimal(valor);
  }

  public BigDecimal getValor() {
    return this.valor;
  }
}
