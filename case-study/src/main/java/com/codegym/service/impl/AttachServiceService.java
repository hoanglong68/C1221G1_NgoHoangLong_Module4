package com.codegym.service.impl;

import com.codegym.model.contract.AttachService;
import com.codegym.repository.IAttachServiceRepository;
import com.codegym.service.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceService implements IAttachServiceService {
    @Autowired
    private IAttachServiceRepository iAttachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return iAttachServiceRepository.findAll();
    }
}
