package com.codegym.service;

import com.codegym.model.SmartPhone;
import com.codegym.repository.ISmartPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SmartPhoneService implements ISmartPhoneService{
    @Autowired
    private ISmartPhoneRepository iSmartPhoneRepository;
    @Override
    public Iterable<SmartPhone> findAll() {
        return iSmartPhoneRepository.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return iSmartPhoneRepository.findById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return iSmartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(Long id) {
        iSmartPhoneRepository.deleteById(id);
    }
}
