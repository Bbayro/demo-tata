package com.Currency.Converter.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConverterRequest {

    private Double monto;
    private Double resultado;
    private Double tipocambio;
    private String origen;
    private String destino;

}