package com.codegym.controller;

import com.codegym.dto.EmployeeDto;
import com.codegym.model.Employee;
import com.codegym.service.IDivisionService;
import com.codegym.service.IEducationDegreeService;
import com.codegym.service.IEmployeeService;
import com.codegym.service.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IPositionService iPositionService;

    @Autowired
    private IDivisionService iDivisionService;

    @Autowired
    private IEducationDegreeService iEducationDegreeService;

    @GetMapping(value = "/list")
    public String goListEmployee(Model model, @PageableDefault(value = 4) Pageable pageable) {
        model.addAttribute("employeeList", this.iEmployeeService.findAll(pageable));
        return "/employee/list";
    }

    @GetMapping(value = "/create")
    public String goCreateForm(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("positionList", this.iPositionService.findAll());
        model.addAttribute("divisionList", this.iDivisionService.findAll());
        model.addAttribute("educationDegreeList", this.iEducationDegreeService.findAll());
        return "/employee/create";
    }

    @PostMapping(value = "/create")
    public String doCreateEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        this.iEmployeeService.save(employee);
        return "redirect:/employee/list";
    }

    @GetMapping(value = "/edit")
    public String goEditForm(Model model,
                             @RequestParam String id) {
        Employee employee = this.iEmployeeService.findById(id);
        if (employee == null) {
            return "error";
        }
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        model.addAttribute("employeeDto", employeeDto);
        model.addAttribute("positionList", this.iPositionService.findAll());
        model.addAttribute("divisionList", this.iDivisionService.findAll());
        model.addAttribute("educationDegreeList", this.iEducationDegreeService.findAll());
        return "employee/edit";
    }

    @PostMapping(value = "/edit")
    public String doEditEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        this.iEmployeeService.save(employee);
        return "redirect:/employee/list";
    }

    @PostMapping(value = "/delete")
    public String doDeleteEmployee(@RequestParam String id) {
        Employee employee = this.iEmployeeService.findById(id);
        if (employee == null) {
            return "error";
        }
        this.iEmployeeService.delete(employee);
        return "redirect:/employee/list";
    }
}
