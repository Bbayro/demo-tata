package com.Currency.Converter.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ConverterNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ConverterNotFoundException(String message){
        super(message);
    }

}
