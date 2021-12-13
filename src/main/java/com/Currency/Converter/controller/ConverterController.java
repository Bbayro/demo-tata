package com.Currency.Converter.controller;


import com.Currency.Converter.model.dto.ConverterRequest;
import com.Currency.Converter.model.dto.ConverterResponse;
import com.Currency.Converter.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {

    @Autowired
    private ConverterService service;


    @PostMapping("/currencyconverter")
    public ResponseEntity<ConverterResponse> convert(@RequestBody ConverterRequest converterRequest) {
        ConverterResponse response = service.executeExchange(converterRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/exchangerateupdate")
    public ResponseEntity<Void> update(@RequestBody ConverterRequest converterRequest) {
        service.updateExchangeRate(converterRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
