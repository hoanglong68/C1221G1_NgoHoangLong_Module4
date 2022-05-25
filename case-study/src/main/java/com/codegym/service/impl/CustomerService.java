package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(String id) {
        return iCustomerRepository.findById(Integer.parseInt(id)).orElse(null);
    }

    @Override
    public void delete(Customer customer) {
        iCustomerRepository.delete(customer);
    }

    @Override
    public Page<Customer> findAllByProperties(String keyword1, String keyword2, String keyword3, Pageable pageable) {
        if ("".equals(keyword3)) {
            return iCustomerRepository
                    .findAllByCustomerNameContainingAndCustomerAddressContaining
                            (keyword1, keyword2, pageable);
        }
        return iCustomerRepository
                .findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerType_CustomerTypeId
                        (keyword1, keyword2, Integer.parseInt(keyword3), pageable);
    }
}
