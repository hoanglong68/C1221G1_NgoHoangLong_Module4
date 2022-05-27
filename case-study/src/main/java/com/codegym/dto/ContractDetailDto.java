package com.codegym.dto;

import com.codegym.model.contract.AttachService;
import com.codegym.model.contract.Contract;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContractDetailDto implements Validator {
    private Integer contractDetailId;
    private Contract contract;
    private AttachService attachService;
    private Integer quantity;
    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
