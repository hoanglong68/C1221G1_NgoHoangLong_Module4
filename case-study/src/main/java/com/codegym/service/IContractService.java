package com.codegym.service;

import com.codegym.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> findAllByPage(Pageable pageable);

    Contract save(Contract contract);

    List<Contract> findAll();
}
