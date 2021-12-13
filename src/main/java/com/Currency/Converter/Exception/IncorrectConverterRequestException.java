package com.Currency.Converter.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class IncorrectConverterRequestException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public IncorrectConverterRequestException() {
        super();
    }

    public IncorrectConverterRequestException(String message) {
        super(message);
    }

    public IncorrectConverterRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectConverterRequestException(Throwable cause) {
        super(cause);
    }

    public IncorrectConverterRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
