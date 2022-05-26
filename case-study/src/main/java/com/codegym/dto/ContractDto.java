package com.codegym.dto;

import com.codegym.model.Contract;
import com.codegym.model.Customer;
import com.codegym.model.Employee;
import com.codegym.model.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class ContractDto implements Validator {
    private Integer contractId;

    private String contractStartDate;

    private String contractEndDate;
    @Positive(message = "must be positive number !")
    private Double contractDeposit;

    private Double contractTotalMoney = 0.0;

    @NotNull(message = "pls confirm your customer !")
    private Customer customer;

    @NotNull(message = "pls confirm your employee !")
    private Employee employee;

    @NotNull(message = "pls confirm your service !")
    private Service service;

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(Double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        if ("".equals(contractDto.contractStartDate)) {
            errors.rejectValue("contractStartDate", "dob.checkEmpty", "giảng làm !");
        } else if (!LocalDate.parse(contractDto.contractStartDate).isAfter(LocalDate.now())) {
            errors.rejectValue("contractStartDate", "contract.checkStartDate", "giảng làm !");
        } else if ("".equals(contractDto.contractEndDate)) {
            errors.rejectValue("contractEndDate", "dob.checkEmpty", "giảng làm !");
        } else if (!LocalDate.parse(contractDto.contractEndDate).isAfter(LocalDate.parse(contractDto.contractStartDate))) {
            errors.rejectValue("contractEndDate", "contract.checkEndDate", "giảng làm !");
        }
    }
}
