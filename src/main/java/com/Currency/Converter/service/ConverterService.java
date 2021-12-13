package com.Currency.Converter.service;

import com.Currency.Converter.utils.common.ExceptionMessagesEnum;
import com.Currency.Converter.model.exception.IncorrectConverterRequestException;
import com.Currency.Converter.repository.ConverterRepository;
import com.Currency.Converter.model.dto.ConverterRequest;
import com.Currency.Converter.model.dto.ConverterResponse;
import com.Currency.Converter.model.entities.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {

    @Autowired
    private ConverterRepository repository;

    public ConverterResponse executeExchange(ConverterRequest converterRequest) {
        return execute(converterRequest);
    }

    public void updateExchangeRate(ConverterRequest converterRequest) {
        updateRate(converterRequest);
    }

    private void updateRate(ConverterRequest converterRequest) {

        ExchangeRate exchangeRate = repository.findByOrigenAndAndDestino(converterRequest.getOrigen(), converterRequest.getDestino());

        if (exchangeRate == null) {
            exchangeRate = new ExchangeRate();
        }

        exchangeRate.setOrigen(converterRequest.getOrigen());
        exchangeRate.setDestino(converterRequest.getDestino());
        exchangeRate.setTipocambio(converterRequest.getTipocambio());

        repository.save(exchangeRate);
    }

    private ConverterResponse execute(ConverterRequest converterRequest) {

        ConverterResponse response = new ConverterResponse();

        ExchangeRate exchangeRate = repository.findByOrigenAndAndDestino(converterRequest.getOrigen(), converterRequest.getDestino());

        if (exchangeRate != null) {
            response.setOrigen(converterRequest.getOrigen());
            response.setDestino(converterRequest.getDestino());
            response.setTipocambio(exchangeRate.getTipocambio());
            response.setMonto(converterRequest.getMonto());
            response.setResultado(exchangeRate.getTipocambio() * converterRequest.getMonto());
        } else {
            throw new IncorrectConverterRequestException(ExceptionMessagesEnum.INCORRECT_REQUEST_EMPTY_ITEMS_ORDER.getValue());
        }

        return response;
    }

}


