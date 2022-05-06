package com.codegym.controller;

import com.codegym.model.YTe;
import com.codegym.service.IYTeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class YTeController {
    @Autowired
    IYTeService iyTeService;

    @GetMapping(value = "/create")
    public String goCreate(Model model) {
        model.addAttribute("yTe", new YTe());
        return "create";
    }

    @PostMapping(value = "/create")
    public String saveYTe(@ModelAttribute YTe yTe, Model model) {
        this.iyTeService.saveYTe(yTe);
        model.addAttribute("yTe", yTe);
        return "info";
    }

    @PostMapping(value = "/edit")
    public String editYTe(Model model) {
        model.addAttribute("yTe", this.iyTeService.getYTe());
        return "create";
    }
}
