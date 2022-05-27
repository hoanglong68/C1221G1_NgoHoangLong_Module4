package com.codegym.controller;

import com.codegym.dto.ContractDetailDto;
import com.codegym.dto.ContractDto;
import com.codegym.model.contract.AttachService;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.service.Service;
import com.codegym.service.*;
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
    @Autowired
    private IContractDetailService iContractDetailService;
    @Autowired
    private IAttachServiceService iAttachServiceService;

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
    @ModelAttribute("attachServiceList")
    public List<AttachService> attachServiceList() {
        return this.iAttachServiceService.findAll();
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
    @GetMapping("/create-with-detail")
    public String goCreateDetailForm(Model model) {
        model.addAttribute("contractDetailDto", new ContractDetailDto());
        return "contract/create-with-detail";
    }
    @PostMapping("/create-with-detail")
    public String doCreateContractWithDetail(@Validated ContractDetailDto contractDetailDto,
                                   BindingResult bindingResult
    ) {
        new ContractDetailDto().validate(contractDetailDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "contract/create-with-detail";
        }
        Contract contract = new Contract();
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto.getContract(), contract);
        BeanUtils.copyProperties(contractDetailDto, contractDetail);
        contract = this.iContractService.save(contract);
        contractDetail.setContract(contract);
        this.iContractDetailService.save(contractDetail);
        return "redirect:/contract/list";
    }
    @PostMapping("create")
    public String doCreateContract(@Validated ContractDto contractDto,
                                             BindingResult bindingResult){
        Contract contract = new Contract();
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "contract/create";
        }
        BeanUtils.copyProperties(contractDto,contract);
        this.iContractService.save(contract);
        return "redirect:/contract/list";
    }
}
