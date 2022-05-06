package com.codegym.controller;

import com.codegym.model.Medical;
import com.codegym.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MedicalController {
    @Autowired
    IMedicalService IMedicalService;

    @GetMapping(value = "/")
    public String goCreate(Model model) {
        model.addAttribute("medical", new Medical());
        return "create";
    }

    @PostMapping(value = "/create")
    public String saveYTe(@ModelAttribute Medical medical, Model model) {
        this.IMedicalService.saveYTe(medical);
        model.addAttribute("medical", medical);
        return "info";
    }

    @PostMapping(value = "/edit")
    public String editYTe(
            Model model) {
        model.addAttribute("medical", this.IMedicalService.getYTe());
        return "create";
    }
}
