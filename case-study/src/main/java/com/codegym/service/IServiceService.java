package com.codegym.service;

import com.codegym.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {
    void save(Service service);

    Page<Service> findAllByPage(Pageable pageable);

    List<Service> findAll();
}
