package com.Currency.Converter.Repository;

import com.Currency.Converter.entities.ExchangePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface ConverterRepository extends JpaRepository<ExchangePost, Long> {

       ExchangePost findByOrigenAndAndDestino(String origen, String destino);
 }

