package com.codegym.service.impl;

import com.codegym.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService {

    @Override
    public String calculate(Character character, String num1, String num2) {
        String result = null;
        switch (character) {
            case '+':
                try {
                    result = String.valueOf(Integer.parseInt(num1) + Integer.parseInt(num2));
                } catch (NumberFormatException numberFormatException) {
                    result = "num1 and num2 is not empty !";
                }
                break;
            case '-':
                try {
                    result = String.valueOf(Integer.parseInt(num1) - Integer.parseInt(num2));
                } catch (NumberFormatException numberFormatException) {
                    result = "num1 and num2 is not empty !";
                }
                break;
            case '*':
                try {
                    result = String.valueOf(Integer.parseInt(num1) * Integer.parseInt(num2));
                } catch (NumberFormatException numberFormatException) {
                    result = "num1 and num2 is not empty !";
                }
                break;
            case '/':
                try {
                    result = String.valueOf(Float.parseFloat(num1) / Float.parseFloat(num2));
                } catch (NumberFormatException numberFormatException) {
                    result = "num1 and num2 is not empty !";
                }
                break;
            default:
                break;
        }
        return result;
    }
}
