package com.example.currency_conversion.service.impl;

import com.example.currency_conversion.service.ICurrencyConversionService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionService implements ICurrencyConversionService {

    @Override
    public Double changeMoney(double usd) {
        double vnd= 24000 * usd;
        return vnd;
    }
}
