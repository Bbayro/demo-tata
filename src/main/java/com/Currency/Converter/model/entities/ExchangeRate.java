package com.Currency.Converter.model.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "exchange_rate")
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Rate")
    private Double tipocambio;

    @Column(name = "From_Currency")
    private String origen;

    @Column(name = "To_Currency")
    private String destino;

}