package com.codegym.controller;

import com.codegym.dto.ProductOrderDto;
import com.codegym.model.Product;
import com.codegym.model.ProductOrder;
import com.codegym.service.IProductOrderService;
import com.codegym.service.IProductService;
import com.codegym.service.IProductTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private IProductOrderService productOrderService;
    @Autowired
    private IProductTypeService productTypeService;
    @GetMapping("/list")
    public String goListProduct(Model model,
                                Optional<String> beforeBuyDate,
                                Optional<String> afterBuyDate,
                                @PageableDefault(value = 2) Pageable pageable) {
        String before = beforeBuyDate.orElse("");
        String after = afterBuyDate.orElse("");
        model.addAttribute("productOrderList", this.productOrderService.findAllByBuyDate(before, after, pageable));
        return "list";
    }

    @GetMapping("/show-top")
    public String searchProduct(Model model,
                                Optional<String> limit) {
        String limitPage = limit.orElse("");
        model.addAttribute("productOrderList",this.productOrderService.findTop(limitPage));
        return "top-list";
    }
    @GetMapping("/edit")
    public String goEditForm(Model model,Optional<String> id){
        String idProduct = id.orElse("");
        ProductOrder productOrder = this.productOrderService.findById(idProduct);
        ProductOrderDto productOrderDto = new ProductOrderDto();
        BeanUtils.copyProperties(productOrder,productOrderDto);
        model.addAttribute("productOrderDto",productOrderDto);
        model.addAttribute("productList",this.productService.findAll());
        model.addAttribute("productTypeList",this.productTypeService.findAll());
        return "edit";
    }
    @PostMapping("/edit")
    public String doEdit(@Validated ProductOrderDto productOrderDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){
        new ProductOrderDto().validate(productOrderDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "edit";
        }
        ProductOrder productOrder = new ProductOrder();
        BeanUtils.copyProperties(productOrderDto,productOrder);
        this.productOrderService.save(productOrder);
        redirectAttributes.addFlashAttribute("message","edited success !");
        return "redirect:/product/list";
    }
}
