package com.Currency.Converter.Repository;

import com.Currency.Converter.entities.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConverterRepository extends JpaRepository<ExchangeRate, Long> {

    ExchangeRate findByOrigenAndAndDestino(String origen, String destino);
}

