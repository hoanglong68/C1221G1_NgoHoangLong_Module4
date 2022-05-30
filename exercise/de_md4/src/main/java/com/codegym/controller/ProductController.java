package com.codegym.controller;

import com.codegym.dto.ProductOrderDto;
import com.codegym.model.Product;
import com.codegym.model.ProductOrder;
import com.codegym.model.ProductType;
import com.codegym.service.IProductOrderService;
import com.codegym.service.IProductService;
import com.codegym.service.IProductTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
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

    @ModelAttribute("productList")
    public List<Product> productList() {
        return this.productService.findAll();
    }

    @ModelAttribute("productTypeList")
    public List<ProductType> productTypeList() {
        return this.productTypeService.findAll();
    }

    @GetMapping("/list")
    public String goListProduct(Model model,
                                Optional<String> beforeBuyDate,
                                Optional<String> afterBuyDate,
                                Optional<String> sort,
                                @RequestParam(defaultValue = "5") Integer pageSize,
                                @RequestParam(defaultValue = "0") Integer page) {
        Pageable pageable;
        String before = beforeBuyDate.orElse("");
        String after = afterBuyDate.orElse("");
        String sortVal = sort.orElse("");
        if (!"".equals(sortVal)) {
            pageable = PageRequest.of(page, pageSize);
            //
            model.addAttribute("productOrderList", this.productOrderService.findTopTotalMoney(pageable));
            return "list";
        }
        pageable = PageRequest.of(page, 3);
        model.addAttribute("productOrderList", this.productOrderService.findAllByBuyDate(before, after, pageable));
        return "list";
    }
    @GetMapping("/create")
    public String goCreateForm(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/create")
    public String doCreate(Product product){
        this.productService.save(product);
        return "redirect:/product/list"
;    }
    @GetMapping("/edit")
    public String goEditForm(Model model, Optional<String> id) {
        String idProduct = id.orElse("");
        ProductOrder productOrder = this.productOrderService.findById(idProduct);
        ProductOrderDto productOrderDto = new ProductOrderDto();
        BeanUtils.copyProperties(productOrder, productOrderDto);
        model.addAttribute("productOrderDto", productOrderDto);
        return "edit";
    }

    @PostMapping("/edit")
    public String doEdit(@Validated ProductOrderDto productOrderDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        new ProductOrderDto().validate(productOrderDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "edit";
        }
        ProductOrder productOrder = new ProductOrder();
        BeanUtils.copyProperties(productOrderDto, productOrder);
        this.productOrderService.save(productOrder);
        redirectAttributes.addFlashAttribute("message", "edited success !");
        return "redirect:/product/list";
    }
}
