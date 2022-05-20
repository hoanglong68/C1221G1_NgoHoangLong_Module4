package com.codegym.controller;

import com.codegym.model.SmartPhone;
import com.codegym.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SmartPhoneController {
    @Autowired
    private ISmartPhoneService iSmartPhoneService;

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }
}
