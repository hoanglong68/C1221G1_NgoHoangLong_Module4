package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", iProductService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @SessionAttribute Cart cart,
                            @RequestParam Optional<String> action) {
        System.out.println(action);
        Product product = iProductService.findById(id).orElse(null);
        if (product == null) {
            return "/error";
        }
        if (action.isPresent()) {
            cart.addProduct(product);
            return "redirect:/shopping-cart";
        }
        cart.addProduct(product);
        return "redirect:/shop";
    }

    @GetMapping("/delete/{id}")
    public String deleteFromCart(@PathVariable Long id, @SessionAttribute Cart cart) {
        Product product = iProductService.findById(id).orElse(null);
        if (product == null) {
            return "/error";
        } else {
            cart.deleteProduct(product);
            return "redirect:/shopping-cart";
        }
    }
}