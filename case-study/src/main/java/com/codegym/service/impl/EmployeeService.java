package com.codegym.service.impl;

import com.codegym.model.Employee;
import com.codegym.repository.IEmployeeRepository;
import com.codegym.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        iEmployeeRepository.delete(employee);
    }

    @Override
    public Page<Employee> findAllByProperties
            (String keyword1, String keyword2, String keyword3, String keyword4, String keyword5, Pageable pageable) {
        if ("".equals(keyword3) && "".equals(keyword4) && "".equals(keyword5)) {
            return iEmployeeRepository.findAllByEmployeeNameContainingAndEmployeeAddressContaining
                    (keyword1, keyword2, pageable);
        } else if (!"".equals(keyword3) && "".equals(keyword4) && "".equals(keyword5)) {
            return iEmployeeRepository.findAllByEmployeeNameContainingAndEmployeeAddressContainingAndPosition_PositionId
                    (keyword1, keyword2, Integer.parseInt(keyword3), pageable);
        } else if ("".equals(keyword3) && !"".equals(keyword4) && "".equals(keyword5)) {
            return iEmployeeRepository.findAllByEmployeeNameContainingAndEmployeeAddressContainingAndEducationDegree_EducationDegreeId
                    (keyword1, keyword2, Integer.parseInt(keyword4), pageable);
        } else if ("".equals(keyword3) && "".equals(keyword4) && !"".equals(keyword5)) {
            return iEmployeeRepository.findAllByEmployeeNameContainingAndEmployeeAddressContainingAndDivision_DivisionId
                    (keyword1, keyword2, Integer.parseInt(keyword5), pageable);
        } else if (!"".equals(keyword3) && !"".equals(keyword4) && "".equals(keyword5)) {
            return iEmployeeRepository.findAllByEmployeeNameContainingAndEmployeeAddressContainingAndPosition_PositionIdAndEducationDegree_EducationDegreeId
                    (keyword1, keyword2, Integer.parseInt(keyword3), Integer.parseInt(keyword4), pageable);
        } else if (!"".equals(keyword3) && "".equals(keyword4) && !"".equals(keyword5)) {
            return iEmployeeRepository.findAllByEmployeeNameContainingAndEmployeeAddressContainingAndPosition_PositionIdAndDivision_DivisionId
                    (keyword1, keyword2, Integer.parseInt(keyword3), Integer.parseInt(keyword5), pageable);
        } else if ("".equals(keyword3) && !"".equals(keyword4) && !"".equals(keyword5)) {
            return iEmployeeRepository.findAllByEmployeeNameContainingAndEmployeeAddressContainingAndEducationDegree_EducationDegreeIdAndDivision_DivisionId
                    (keyword1, keyword2, Integer.parseInt(keyword4), Integer.parseInt(keyword5), pageable);
        } else {
            return iEmployeeRepository.findAllByEmployeeNameContainingAndEmployeeAddressContainingAndPosition_PositionIdAndEducationDegree_EducationDegreeIdAndDivision_DivisionId
                    (keyword1, keyword2, Integer.parseInt(keyword3), Integer.parseInt(keyword4), Integer.parseInt(keyword5), pageable);
        }
    }
}