package com.example.currency_conversion.controller;

import com.example.currency_conversion.service.ICurrencyConversionService;
import com.example.currency_conversion.service.impl.CurrencyConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/currency")
public class CurrencyConversionController {
    private ICurrencyConversionService iCurrencyConversionService= new CurrencyConversionService();
    @GetMapping("")
    public String currencyConversion(@RequestParam(required = false)Double usd, Double vnd,Model model){
        if(usd==null){
            model.addAttribute("usd",usd);
            return "list";
        }
        model.addAttribute("usd",usd);
        model.addAttribute("vnd",iCurrencyConversionService.changeMoney(usd));
        return "list";
    }

}
