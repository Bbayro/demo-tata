package com.Currency.Converter.Common;

import com.Currency.Converter.entities.ExchangePost;
import com.Currency.Converter.dto.ConverterResponse;
import com.Currency.Converter.entities.ExchangeRate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityDtoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public ConverterResponse convertEntityToDto(ExchangePost exchangePost){
        return  modelMapper.map(exchangePost, ConverterResponse.class);
    }

    public ConverterResponse convertEntityToDto2(ExchangeRate exchangeRate){
        return  modelMapper.map(exchangeRate, ConverterResponse.class);
    }

}