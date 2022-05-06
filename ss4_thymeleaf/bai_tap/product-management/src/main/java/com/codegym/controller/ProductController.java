package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    IProductService iProductService;

    @GetMapping(value = "/list")
    public String goList(Model model) {
        model.addAttribute("productList", this.iProductService.getProductList());
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreateForm(Model model) {
        model.addAttribute("id", Math.round(Math.random() * 1000));
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping(value = "/create")
    public String createProduct(@ModelAttribute Product product,
                                RedirectAttributes redirectAttributes) {
        this.iProductService.createProduct(product);
        redirectAttributes.addFlashAttribute("message", "create successful !");
        return "redirect:/list";
    }

    @GetMapping
    public String goDeleteForm(Model model,
                               @ModelAttribute String id) {
        model.addAttribute("product", this.iProductService.findProductById(id));
        return "delete";
    }

    @PostMapping
    public String deleteProduct(@ModelAttribute Product product,
                                RedirectAttributes redirectAttributes) {
        this.iProductService.removeProduct(product);
        redirectAttributes.addFlashAttribute("message", "delete successful !");
        return "redirect:/list";
    }
}
