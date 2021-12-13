package com.Currency.Converter.Controller;


import com.Currency.Converter.Common.EntityDtoConverter;
import com.Currency.Converter.entities.ExchangePost;
import com.Currency.Converter.entities.ExchangeRate;
import com.Currency.Converter.Service.ConverterService;
import com.Currency.Converter.dto.ConverterRequest;
import com.Currency.Converter.dto.ConverterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConverterController {

    @Autowired
    Environment environment;

    @Autowired
    private ConverterService converterService;

    @Autowired
    private EntityDtoConverter converter;

    @PostMapping("/currencyconverter")
    public ResponseEntity<ConverterResponse> createOperation (@RequestBody ConverterRequest converterRequest){
        ExchangeRate exchangeRate=converterService.createExchange(converterRequest);
        return new ResponseEntity<ConverterResponse>(converter.convertEntityToDto2(exchangeRate), HttpStatus.CREATED);
    }

    @PostMapping("/exchangerateupdate")
    public ResponseEntity<Void> createOperation1 (@RequestBody ConverterRequest converterRequest){
        ExchangePost exchangePost=converterService.createExchangePost(converterRequest);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
