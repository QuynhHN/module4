package com.example.caculator.controller;

import com.example.caculator.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/caculator")
public class CaculatorController {
    @Autowired
    ICaculatorService calculatorService;

    @GetMapping("")
    public String caculate(@RequestParam(required = false) Double number1, Double number2,
                            String caculate, Model model) {
        if (number1 == null & number2 == null) {
            return "list";
        }
        String message = "";
        String caculationMessage = "";
        double result = calculatorService.performCalculation(caculate, number1, number2);
        switch (caculate) {
            case "Addition(+)":
                caculationMessage = "addition";
                break;
            case "Subtraction(-)":
                caculationMessage = "subtraction";
                break;
            case "Multiplication(*)":
                caculationMessage = "multiplication";
                break;
            case "Division(/)":
                if (result != 0) {
                    caculationMessage = "division";
                } else {
                    message = "Please enter a number other than 0";
                }
                break;
        }
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("result", result);
        model.addAttribute("message", message);
        model.addAttribute("caculationMessage", caculationMessage);
        return "list";
    }
}
