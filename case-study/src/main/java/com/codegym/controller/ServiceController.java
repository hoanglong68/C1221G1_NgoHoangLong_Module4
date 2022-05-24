package com.codegym.controller;

import com.codegym.dto.ServiceDto;
import com.codegym.service.IFacilityTypeService;
import com.codegym.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/service")
public class ServiceController {
    @Autowired
    private IFacilityTypeService iFacilityTypeService;
    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping(value = "/create")
    public String goCreateForm(Model model){
        model.addAttribute("serviceDto",new ServiceDto());
        model.addAttribute("rentTypeList",this.iRentTypeService.findAll());
        model.addAttribute("facilityTypeList",this.iFacilityTypeService.findAll());
        return "/service/create";
    }
}
