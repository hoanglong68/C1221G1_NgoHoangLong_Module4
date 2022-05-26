package com.codegym.dto;

import com.codegym.model.AttachService;
import com.codegym.model.Contract;

public class ContractDetailDto {
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
}
