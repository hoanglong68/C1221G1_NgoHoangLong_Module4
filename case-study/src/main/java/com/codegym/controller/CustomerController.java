package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.service.ICustomerService;
import com.codegym.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @ModelAttribute("customerTypeList")
    public List<CustomerType> customerTypeList() {
        return this.iCustomerTypeService.findAll();
    }

    @GetMapping(value = "list")
    public String goListCustomer(Model model,
                                 @PageableDefault(value = 4) Pageable pageable,
                                 @RequestParam Optional<String> nameQuery,
                                 @RequestParam Optional<String> addressQuery,
                                 @RequestParam Optional<String> customerTypeQuery
    ) {
        String keyword1 = nameQuery.orElse("");
        String keyword2 = addressQuery.orElse("");
        String keyword3 = customerTypeQuery.orElse("");
        model.addAttribute("keywordVal1", keyword1);
        model.addAttribute("keywordVal2", keyword2);
        model.addAttribute("keywordVal3", keyword3);
        model.addAttribute("customerList", iCustomerService.findAllByProperties(keyword1, keyword2, keyword3, pageable));
        return "/customer/list";
    }

    @GetMapping(value = "create")
    public String goCreateForm(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "/customer/create";
    }

    @PostMapping(value = "create")
    public String doCreateCustomer(@Validated CustomerDto customerDto,
                                   BindingResult bindingResult) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        this.iCustomerService.save(customer);
        return "redirect:/customer/list";
    }

    @GetMapping(value = "edit")
    public String goEditForm(Model model,
                             @RequestParam String id) {
        Customer customer = this.iCustomerService.findById(id);
        if (customer == null) {
            return "error";
        }
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        model.addAttribute("customerDto", customerDto);
        return "customer/edit";
    }

    @PostMapping(value = "edit")
    public String doEditCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        this.iCustomerService.save(customer);
        return "redirect:/customer/list";
    }

    @PostMapping(value = "delete")
    public String doDeleteCustomer(@RequestParam String id) {
        Customer customer = this.iCustomerService.findById(id);
        if (customer == null) {
            return "error";
        }
        this.iCustomerService.delete(customer);
        return "redirect:/customer/list";
    }
    @GetMapping("occ-list")
    public String goOccList(Model model){
        model.addAttribute("occupiedList",this.iCustomerService.findAllOcc());
        return "customer/occ-list";
    }

}
