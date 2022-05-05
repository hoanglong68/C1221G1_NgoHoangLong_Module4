package com.codegym.controller;

import com.codegym.model.Email;
import com.codegym.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {
    @Autowired
    IEmailService iEmailService;

    @GetMapping(value = "/settings")
    public String goSettings(Model model) {
        model.addAttribute("email", new Email());
        return "settings";
    }

    @GetMapping
    public String goList(Model model) {
        model.addAttribute("emailList", this.iEmailService.getList());
        return "list";
    }

    @PostMapping
    public String settings(@ModelAttribute Email email,
                           RedirectAttributes redirectAttributes) {
        this.iEmailService.save(email);
        redirectAttributes.addFlashAttribute("message", "updated successful !");
        return "redirect:/settings";
    }
}
