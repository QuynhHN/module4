package com.example.caculator.service.impl;

import com.example.caculator.service.ICaculatorService;
import org.springframework.stereotype.Service;

@Service
public class CaculatorService implements ICaculatorService {
    @Override
    public double performCalculation(String calculate, double numberFirst, double numberSecond) {
        switch (calculate) {
            case "Addition(+)":
               return numberFirst + numberSecond;
            case "Subtraction(-)":
                return numberFirst - numberSecond;
            case "Multiplication(*)":
                return numberFirst * numberSecond;
            case "Division(/)":
                    return numberFirst / numberSecond;
        }
        return 0;
    }
}
