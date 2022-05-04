package com.codegym.controller;

import com.codegym.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @Autowired
    ISandwichService iSandwichService;
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping(value = "/result")
    public String save(@RequestParam(value = "condiment",defaultValue = "ko co gi") String[] condiment,
                       Model model) {
        model.addAttribute("condimentlist",condiment);
//        model.addAttribute("condimentlist",this.iSandwichService.check(condiment));
           return "result";
    }
}
