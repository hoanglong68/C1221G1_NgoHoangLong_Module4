package com.codegym.service;

import com.codegym.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> findAllByPage(Pageable pageable);

    void save(Contract contract);

    List<Contract> findAll();
}
