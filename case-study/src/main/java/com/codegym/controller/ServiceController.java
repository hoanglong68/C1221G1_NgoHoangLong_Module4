package com.codegym.controller;

import com.codegym.dto.ServiceDto;
import com.codegym.model.service.Service;
import com.codegym.service.IFacilityTypeService;
import com.codegym.service.IRentTypeService;
import com.codegym.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/service")
public class ServiceController {
    @Autowired
    private IServiceService iServiceService;
    @Autowired
    private IFacilityTypeService iFacilityTypeService;
    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping(value = "/list")
    public String goListService(Model model,@PageableDefault(value = 3) Pageable pageable) {
        model.addAttribute("serviceList", this.iServiceService.findAllByPage(pageable));
        return "/service/list";
    }

    @GetMapping(value = "/create")
    public String goCreateForm(Model model) {
        model.addAttribute("serviceDto", new ServiceDto());
        model.addAttribute("rentTypeList", this.iRentTypeService.findAll());
        model.addAttribute("facilityTypeList", this.iFacilityTypeService.findAll());
        return "/service/create";
    }

    @PostMapping(value = "/create")
    public String doCreateService(ServiceDto serviceDto) {
        Service service = new Service();
        BeanUtils.copyProperties(serviceDto, service);
        this.iServiceService.save(service);
        return "redirect:/service/list";
    }
}
