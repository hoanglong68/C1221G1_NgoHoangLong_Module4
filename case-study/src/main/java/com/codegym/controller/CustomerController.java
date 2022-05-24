package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import com.codegym.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping(value = "list")
    public String goListCustomer(Model model, @PageableDefault(value = 4) Pageable pageable) {
        model.addAttribute("customerList", iCustomerService.findAll(pageable));
        return "/customer/list";
    }

    @GetMapping(value = "create")
    public String goCreateForm(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypeList", this.iCustomerTypeService.findAll());
        return "/customer/create";
    }

    @PostMapping(value = "create")
    public String doCreateCustomer(CustomerDto customerDto) {
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
        model.addAttribute("customerTypeList", this.iCustomerTypeService.findAll());
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
}
