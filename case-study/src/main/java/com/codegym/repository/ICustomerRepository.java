package com.codegym.repository;

import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update customer set customer_status = false where customer_id = :customerId",
            nativeQuery = true)
    void updateStatusCustomer(Integer customerId);

    @Query(value = "select * from customer where customer_name like :customerName and customer_address like :customerAddress " +
            "and customer_type_id like :customerTypeId and customer_status = true", nativeQuery = true)
    Page<Customer> findAllByProperties(String customerName, String customerAddress, String customerTypeId,Pageable pageable);

    Page<Customer>
    findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerType_CustomerTypeIdAndCustomerStatus
            (String name, String address, Integer type, Boolean status, Pageable pageable);

    Page<Customer>
    findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerStatus
            (String name, String address, Boolean status, Pageable pageable);
}
