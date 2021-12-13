package com.Currency.Converter.Service;

import com.Currency.Converter.Common.ExceptionMessagesEnum;
import com.Currency.Converter.Exception.IncorrectConverterRequestException;
import com.Currency.Converter.Repository.ConverterRepository;
import com.Currency.Converter.entities.ExchangePost;
import com.Currency.Converter.entities.ExchangeRate;
import com.Currency.Converter.dto.ConverterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class ConverterService {

    @Autowired
    private ConverterRepository converterRepository;

    public ExchangeRate createExchange(ConverterRequest converterRequest) {
        ExchangeRate newRate=initRate(converterRequest);
        return newRate;
    }

    public ExchangePost createExchangePost(ConverterRequest converterRequest) {
        ExchangePost newPost=initPost(converterRequest);
        return newPost;
    }

   private ExchangePost initPost(ConverterRequest converterRequest){
       ExchangePost postObj;

       postObj=converterRepository.findByOrigenAndAndDestino(converterRequest.getOrigen(), converterRequest.getDestino());
        if (postObj != null) {
            postObj.setOrigen(converterRequest.getOrigen());
            postObj.setDestino(converterRequest.getDestino());
            postObj.setTipocambio(converterRequest.getTipocambio());
            converterRepository.save(postObj);
        }
        else {
            postObj = new ExchangePost();
            postObj.setOrigen(converterRequest.getOrigen());
            postObj.setDestino(converterRequest.getDestino());
            postObj.setTipocambio(converterRequest.getTipocambio());
            converterRepository.save(postObj);
        }

       return postObj;

    }

    private ExchangeRate initRate(ConverterRequest converterRequest){
        ExchangeRate rateObj = new ExchangeRate();
        ExchangePost postObj;

        postObj=converterRepository.findByOrigenAndAndDestino(converterRequest.getOrigen(), converterRequest.getDestino());

        if (postObj != null) {
            rateObj.setOrigen(converterRequest.getOrigen());
            rateObj.setDestino(converterRequest.getDestino());
            rateObj.setTipocambio(postObj.getTipocambio());
            rateObj.setMonto(converterRequest.getMonto());
            rateObj.setResultado(postObj.getTipocambio() * converterRequest.getMonto());
        }

        else if (postObj == null){

            throw new IncorrectConverterRequestException(ExceptionMessagesEnum.
                    INCORRECT_REQUEST_EMPTY_ITEMS_ORDER.getValue());
        }

        return rateObj;

    }

}


