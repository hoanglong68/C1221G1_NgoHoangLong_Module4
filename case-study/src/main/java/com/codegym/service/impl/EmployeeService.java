package com.codegym.service.impl;

import com.codegym.model.employee.Employee;
import com.codegym.repository.IEmployeeRepository;
import com.codegym.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;


    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findById(String id) {
        return iEmployeeRepository.findById(Integer.parseInt(id)).orElse(null);
    }

    @Override
    public void delete(Employee employee) {
//        iEmployeeRepository.delete(employee);
        Integer id = employee.getEmployeeId();
        Employee existEmployee = this.iEmployeeRepository.findById(id).orElse(null);
        assert existEmployee != null;
        existEmployee.setEmployeeStatus(false);
        this.iEmployeeRepository.save(existEmployee);
    }

    @Override
    public Page<Employee> findAllByProperties
            (String keyword1, String keyword2, String keyword3, String keyword4, String keyword5, Pageable pageable) {
        if ("".equals(keyword3) && "".equals(keyword4) && "".equals(keyword5)) {
            return iEmployeeRepository.findAllByEmployeeNameContainingAndEmployeeAddressContainingAndEmployeeStatus
                    (keyword1, keyword2, true, pageable);
        } else if (!"".equals(keyword3) && "".equals(keyword4) && "".equals(keyword5)) {
            return iEmployeeRepository.findAllByEmployeeNameContainingAndEmployeeAddressContainingAndPosition_PositionIdAndEmployeeStatus
                    (keyword1, keyword2, Integer.parseInt(keyword3), true, pageable);
        } else if ("".equals(keyword3) && !"".equals(keyword4) && "".equals(keyword5)) {
            return iEmployeeRepository.findAllByEmployeeNameContainingAndEmployeeAddressContainingAndEducationDegree_EducationDegreeIdAndEmployeeStatus
                    (keyword1, keyword2, Integer.parseInt(keyword4), true, pageable);
        } else if ("".equals(keyword3) && "".equals(keyword4) && !"".equals(keyword5)) {
            return iEmployeeRepository.findAllByEmployeeNameContainingAndEmployeeAddressContainingAndDivision_DivisionIdAndEmployeeStatus
                    (keyword1, keyword2, Integer.parseInt(keyword5), true, pageable);
        } else if (!"".equals(keyword3) && !"".equals(keyword4) && "".equals(keyword5)) {
            return iEmployeeRepository.findAllByEmployeeNameContainingAndEmployeeAddressContainingAndPosition_PositionIdAndEducationDegree_EducationDegreeIdAndEmployeeStatus
                    (keyword1, keyword2, Integer.parseInt(keyword3), Integer.parseInt(keyword4), true, pageable);
        } else if (!"".equals(keyword3) && "".equals(keyword4) && !"".equals(keyword5)) {
            return iEmployeeRepository.findAllByEmployeeNameContainingAndEmployeeAddressContainingAndPosition_PositionIdAndDivision_DivisionIdAndEmployeeStatus
                    (keyword1, keyword2, Integer.parseInt(keyword3), Integer.parseInt(keyword5), true, pageable);
        } else if ("".equals(keyword3) && !"".equals(keyword4) && !"".equals(keyword5)) {
            return iEmployeeRepository.findAllByEmployeeNameContainingAndEmployeeAddressContainingAndEducationDegree_EducationDegreeIdAndDivision_DivisionIdAndEmployeeStatus
                    (keyword1, keyword2, Integer.parseInt(keyword4), Integer.parseInt(keyword5), true, pageable);
        } else {
            return iEmployeeRepository.findAllByEmployeeNameContainingAndEmployeeAddressContainingAndPosition_PositionIdAndEducationDegree_EducationDegreeIdAndDivision_DivisionIdAndEmployeeStatus
                    (keyword1, keyword2, Integer.parseInt(keyword3), Integer.parseInt(keyword4), Integer.parseInt(keyword5), true, pageable);
        }
    }

    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }
}