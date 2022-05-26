package com.codegym.service;

import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {

    void save(Employee employee);

    Employee findById(String id);

    void delete(Employee employee);

    Page<Employee> findAllByProperties(String keyword1, String keyword2, String keyword3, String keyword4, String keyword5, Pageable pageable);

    List<Employee> findAll();
}
