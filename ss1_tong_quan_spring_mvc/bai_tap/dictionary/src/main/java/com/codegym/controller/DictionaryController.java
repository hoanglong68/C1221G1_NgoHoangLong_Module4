package com.codegym.controller;

import com.codegym.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    IDictionaryService iDictionaryService;

    @GetMapping(value = "/home")
    public String home() {
        return "home";
    }

    @GetMapping(value = "/translate")
    public String translate(@RequestParam String word,
                            Model model) {
        model.addAttribute("result", this.iDictionaryService.translate(word));
        return "result-search";
    }
}
