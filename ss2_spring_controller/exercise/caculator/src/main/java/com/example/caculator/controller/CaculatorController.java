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
    private ICaculatorService calculatorService;

    @GetMapping("")
    public String caculate(@RequestParam(required = false) Double numberFirst, Double numberSecond,
                            String caculate, Model model) {
        if (numberFirst == null & numberSecond == null) {
            return "list";
        }
        String message = "";
        String caculationMessage = "";
        double result = calculatorService.performCalculation(caculate, numberFirst, numberSecond);
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
        model.addAttribute("numberFirst", numberFirst);
        model.addAttribute("numberSecond", numberSecond);
        model.addAttribute("result", result);
        model.addAttribute("message", message);
        model.addAttribute("caculationMessage", caculationMessage);
        return "list";
    }
}
