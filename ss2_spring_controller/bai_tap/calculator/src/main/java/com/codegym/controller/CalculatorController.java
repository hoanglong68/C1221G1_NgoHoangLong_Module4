package com.codegym.controller;

import com.codegym.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    ICalculatorService iCalculatorService;

    @GetMapping(value = "/")
    String goHome() {
        return "home";
    }

    @PostMapping(value = "/")
    String calulate(
            @RequestParam String num1,
            @RequestParam String num2,
            @RequestParam String operator,
            Model model
    ) {
        model.addAttribute("result", this.iCalculatorService.calculate(operator.charAt(0), num1, num2));
        return "home";
    }
}
