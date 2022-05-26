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
//        iCustomerRepository.updateStatusCustomer(customerId);
        Integer id = customer.getCustomerId();
        Customer existCustomer = iCustomerRepository.findById(id).orElse(null);
        assert existCustomer != null;
        existCustomer.setCustomerStatus(false);
        iCustomerRepository.save(existCustomer);
    }

    @Override
    public Page<Customer> findAllByProperties(String keyword1, String keyword2, String keyword3, Pageable pageable) {
        System.out.println("1:" + keyword3);
        if ("".equals(keyword3)) {
            return iCustomerRepository
                    .findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerStatus
                            (keyword1, keyword2, true, pageable);
        }
        return iCustomerRepository
                .findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerType_CustomerTypeIdAndCustomerStatus
                        (keyword1, keyword2, Integer.parseInt(keyword3), true, pageable);
    }
//        return this.iCustomerRepository.findAllByProperties("%"+keyword1+"%", "%"+keyword2+"%", keyword3, pageable);
//    }
}