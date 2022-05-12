package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping(value = "/list")
    public String goList(Model model,
                         @RequestParam(value = "nameProduct") Optional<String> nameProduct,
                         @RequestParam(value = "nameDescription") Optional<String> nameDescription,
                         @RequestParam(value = "nameManufacturer") Optional<String> nameManufacturer,
                         @PageableDefault(value = 2) Pageable pageable
    ) {
        String keyword1 = nameProduct.orElse("");
        String keyword2 = nameDescription.orElse("");
        String keyword3 = nameManufacturer.orElse("");
        model.addAttribute("keywordVal1", keyword1);
        model.addAttribute("keywordVal2", keyword2);
        model.addAttribute("keywordVal3", keyword3);
        model.addAttribute("productList", this.iProductService.getProductList(keyword1, keyword2, keyword3, pageable));
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping(value = "/create")
    public String createProduct(Product product,
                                RedirectAttributes redirectAttributes) {
        this.iProductService.saveProduct(product);
        redirectAttributes.addFlashAttribute("message", "create successful !");
        return "redirect:/list";
    }

    @PostMapping(value = "/delete")
    public String deleteProduct(Product product,
                                RedirectAttributes redirectAttributes) {
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
    public String editProduct(Product product,
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
}
