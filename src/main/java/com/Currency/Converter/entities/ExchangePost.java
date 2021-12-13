package com.Currency.Converter.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="exchange_rate")
public class ExchangePost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="Rate")
    private Double tipocambio;

    @Column(name="From_Currency")
    private String origen;

    @Column(name="To_Currency")
    private String destino;



}


