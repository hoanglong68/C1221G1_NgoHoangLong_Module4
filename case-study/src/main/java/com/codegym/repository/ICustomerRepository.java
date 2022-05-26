package com.codegym.repository;

import com.codegym.dto.OccupiedCustomerDto;
import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update customer set customer_status = false where customer_id = :customerId",
            nativeQuery = true)
    void updateStatusCustomer(Integer customerId);

    @Query(value = "select * from customer where customer_name like :customerName and customer_address like :customerAddress " +
            "and customer_type_id like :customerTypeId and customer_status = true", nativeQuery = true)
    Page<Customer> findAllByProperties(String customerName, String customerAddress, String customerTypeId, Pageable pageable);

    Page<Customer>
    findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerType_CustomerTypeIdAndCustomerStatus
            (String name, String address, Integer type, Boolean status, Pageable pageable);

    Page<Customer>
    findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerStatus
            (String name, String address, Boolean status, Pageable pageable);

    @Query(value = "select cus.customer_id as occCustomerId ,cus.customer_code as occCustomerCode,cus.customer_name as occCustomerName, cus_type.customer_type_name as occCustomerTypeName, con.contract_start_date as occStartDate, con.contract_end_date as occEndDate, att_sv.attach_service_name as attachServiceName, att_sv.attach_service_status as attachServiceStatus, con_dt.quantity as quantity from customer cus inner join customer_type cus_type on cus.customer_type_id = cus_type.customer_type_id inner join contract con on con.customer_id = cus.customer_id inner join contract_detail con_dt on con_dt.contract_id = con.contract_id inner join attach_service att_sv on att_sv.attach_service_id = con_dt.attach_service_id where datediff(con.contract_end_date, current_date()) > 0 group by con.contract_id", nativeQuery = true)
    List<OccupiedCustomerDto> findAllOcc();
}
