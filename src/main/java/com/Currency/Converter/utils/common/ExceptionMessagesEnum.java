package com.Currency.Converter.utils.common;

public enum ExceptionMessagesEnum {
    INCORRECT_REQUEST_EMPTY_ITEMS_ORDER("Conversion no contemplada");

    private String value;

    ExceptionMessagesEnum(String message){
        this.value=message;

    }

    public String getValue(){
        return value;
    }
}
