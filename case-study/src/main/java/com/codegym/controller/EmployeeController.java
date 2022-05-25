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

import java.util.Optional;

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
    public String goListEmployee(Model model,
                                 @RequestParam Optional<String> nameQuery,
                                 @RequestParam Optional<String> addressQuery,
                                 @RequestParam Optional<String> positionQuery,
                                 @RequestParam Optional<String> educationDegreeQuery,
                                 @RequestParam Optional<String> divisionQuery,
                                 @PageableDefault(value = 4) Pageable pageable) {
        String keyword1 = nameQuery.orElse("");
        String keyword2 = addressQuery.orElse("");
        String keyword3 = positionQuery.orElse("");
        String keyword4 = educationDegreeQuery.orElse("");
        String keyword5 = divisionQuery.orElse("");
        model.addAttribute("keywordVal1", keyword1);
        model.addAttribute("keywordVal2", keyword2);
        model.addAttribute("keywordVal3", keyword3);
        model.addAttribute("keywordVal4", keyword4);
        model.addAttribute("keywordVal5", keyword5);
        model.addAttribute("positionList", this.iPositionService.findAll());
        model.addAttribute("divisionList", this.iDivisionService.findAll());
        model.addAttribute("educationDegreeList", this.iEducationDegreeService.findAll());
        model.addAttribute("employeeList",
                this.iEmployeeService.findAllByProperties
                        (keyword1,keyword2,keyword3,keyword4,keyword5,pageable));
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
