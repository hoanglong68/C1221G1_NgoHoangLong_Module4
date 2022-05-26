package com.codegym.controller;

import com.codegym.dto.ContractDto;
import com.codegym.model.Contract;
import com.codegym.model.Customer;
import com.codegym.model.Employee;
import com.codegym.model.Service;
import com.codegym.service.IContractService;
import com.codegym.service.ICustomerService;
import com.codegym.service.IEmployeeService;
import com.codegym.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/contract")

public class ContractController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IServiceService iServiceService;

    @ModelAttribute("customerList")
    public List<Customer> customerList() {
        return this.iCustomerService.findAll();
    }

    @ModelAttribute("employeeList")
    public List<Employee> employeeList() {
        return this.iEmployeeService.findAll();
    }

    @ModelAttribute("serviceList")
    public List<Service> serviceList() {
        return this.iServiceService.findAll();
    }

    @GetMapping("/list")
    public String goListContract(Model model,
                                 @PageableDefault(value = 3) Pageable pageable) {
        model.addAttribute("contractList", this.iContractService.findAllByPage(pageable));
        return "/contract/list";
    }

    @GetMapping("/create")
    public String goCreateForm(Model model) {
        model.addAttribute("contractDto", new ContractDto());
        return "contract/create";
    }

    @PostMapping("/create")
    public String doCreateContract(@Validated ContractDto contractDto,
                                   BindingResult bindingResult
    ) {
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "contract/create";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        this.iContractService.save(contract);
        return "redirect:/contract/list";
    }
}
