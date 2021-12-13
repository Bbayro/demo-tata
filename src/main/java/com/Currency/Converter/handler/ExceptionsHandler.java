package com.Currency.Converter.handler;

import com.Currency.Converter.model.exception.ConverterNotFoundException;
import com.Currency.Converter.model.exception.ExceptionResponse;
import com.Currency.Converter.model.exception.IncorrectConverterRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RestController
public class ExceptionsHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handlerAllException(Exception exception, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(exception.getMessage(),
                request.getDescription(true), HttpStatus.INTERNAL_SERVER_ERROR,
                LocalDateTime.now());
        return new ResponseEntity<Object>(response, response.getStatus());
    }

    @ExceptionHandler(IncorrectConverterRequestException.class)
    public ResponseEntity<Object> handlerIncorrectException(IncorrectConverterRequestException exception, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(exception.getMessage(),
                request.getDescription(true), HttpStatus.BAD_REQUEST,
                LocalDateTime.now());
        return new ResponseEntity<Object>(response, response.getStatus());
    }

    @ExceptionHandler(ConverterNotFoundException.class)
    public ResponseEntity<Object> handlerOrderNotFoundException(ConverterNotFoundException exception, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(exception.getMessage(),
                request.getDescription(true), HttpStatus.NOT_FOUND,
                LocalDateTime.now());
        return new ResponseEntity<Object>(response, response.getStatus());
    }

}
