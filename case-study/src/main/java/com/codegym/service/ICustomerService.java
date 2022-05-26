package com.codegym.service;

import com.codegym.dto.OccupiedCustomerDto;
import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    void save(Customer customer);

    Customer findById(String id);

    void delete(Customer customer);

    Page<Customer> findAllByProperties(String keyword1, String keyword2, String keyword3, Pageable pageable);

    List<Customer> findAll();

    List<OccupiedCustomerDto> findAllOcc();
}
