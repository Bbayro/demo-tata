package com.Currency.Converter.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConverterResponse {
    private Double tipocambio;
    private String origen;
    private String destino;
    private Double monto;
    private Double resultado;
}
