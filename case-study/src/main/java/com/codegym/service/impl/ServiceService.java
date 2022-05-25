package com.codegym.service.impl;

import com.codegym.repository.IServiceRepository;
import com.codegym.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceService implements IServiceService {
    @Autowired
    IServiceRepository iServiceRepository;

    @Override
    public void save(com.codegym.model.Service service) {
        iServiceRepository.save(service);
    }

    @Override
    public Page<com.codegym.model.Service> findAll(Pageable pageable) {
        return iServiceRepository.findAll(pageable);
    }
}
