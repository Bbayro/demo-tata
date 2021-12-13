package com.Currency.Converter.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeRate {

    private Double tipocambio;

    private String origen;

    private String destino;

    private Double monto;

    private Double resultado;

}
