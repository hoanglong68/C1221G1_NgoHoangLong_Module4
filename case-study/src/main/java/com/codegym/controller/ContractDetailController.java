package com.codegym.controller;

import com.codegym.dto.ContractDetailDto;
import com.codegym.model.ContractDetail;
import com.codegym.service.IAttachServiceService;
import com.codegym.service.IContractDetailService;
import com.codegym.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract-detail")
public class ContractDetailController {
    @Autowired
    private IContractDetailService iContractDetailService;
    @Autowired
    private IContractService iContractService;
    @Autowired
    private IAttachServiceService iAttachServiceService;

    @GetMapping("/create-detail")
    public String goCreateDetailForm(Model model) {
        model.addAttribute("contractDetailDto", new ContractDetailDto());
        model.addAttribute("contractList", this.iContractService.findAll());
        model.addAttribute("attachServiceList", this.iAttachServiceService.findAll());
        return "/contract/create-detail";
    }
    @PostMapping("create-detail")
    public String doCreateContractDetail( ContractDetailDto contractDetailDto){
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto,contractDetail);
        this.iContractDetailService.save(contractDetail);
        return "redirect:/contract/list";
    }
}
