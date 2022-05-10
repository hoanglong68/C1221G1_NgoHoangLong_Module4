package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping(value = "/list")
    public String goList(Model model) {
        model.addAttribute("productList", this.iProductService.getProductList());
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping(value = "/create")
    public String createProduct( Product product,
                                RedirectAttributes redirectAttributes) {
        this.iProductService.createProduct(product);
        redirectAttributes.addFlashAttribute("message", "create successful !");
        return "redirect:/list";
    }

    @GetMapping(value = "/delete")
    public String goDeleteForm(Model model,
                               @RequestParam String id) {
        model.addAttribute("product", this.iProductService.findProductById(Integer.parseInt(id)));
        return "delete";
    }

    @PostMapping(value = "/delete")
    public String deleteProduct( Product product,
                                RedirectAttributes redirectAttributes) {
        System.out.println(product);
        this.iProductService.removeProduct(this.iProductService.findProductById(product.getId()));
        redirectAttributes.addFlashAttribute("message", "delete successful !");
        return "redirect:/list";
    }

    @GetMapping(value = "/edit")
    public String goEditForm(Model model,
                             @RequestParam String id) {
        model.addAttribute("product", this.iProductService.findProductById(Integer.parseInt(id)));
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String editProduct( Product product,
                              RedirectAttributes redirectAttributes) {
        this.iProductService.saveProduct(product);
        redirectAttributes.addFlashAttribute("message", "edit successful !");
        return "redirect:/list";
    }

    @GetMapping(value = "/detail")
    public String detailProduct(Model model,
                                @RequestParam String id) {
        model.addAttribute("product", this.iProductService.findProductById(Integer.parseInt(id)));
        return "detail";
    }

    @GetMapping(value = "/search")
    public String searchProduct(Model model,
                                @RequestParam(value = "nameProduct") String name) {
        System.out.println(this.iProductService.findProductByName(name));
        model.addAttribute("productList", this.iProductService.findProductByName(name));
        return "list";
    }
}
