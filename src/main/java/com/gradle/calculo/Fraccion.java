package com.gradle.calculo;

import java.math.BigDecimal;

public class Fraccion {

  private BigDecimal numerador;

  private BigDecimal denominador;

  public Fraccion() {
    this.numerador = new BigDecimal("0");
    this.denominador = new BigDecimal("1");
  }
}
