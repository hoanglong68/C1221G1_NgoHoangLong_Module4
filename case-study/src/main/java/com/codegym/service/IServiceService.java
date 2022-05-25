package com.codegym.service;

import com.codegym.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceService {
    void save(Service service);

    Page<Service> findAll(Pageable pageable);
}
