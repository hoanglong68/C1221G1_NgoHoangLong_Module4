package com.codegym.service;

import com.codegym.model.Medical;
import com.codegym.repository.IMedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YMedicalServiceImpl implements IMedicalService {
    @Autowired
    IMedicalRepository IMedicalRepository;

    @Override
    public Medical getYTe() {
        return IMedicalRepository.getYTe();
    }

    @Override
    public void saveYTe(Medical medical) {
        IMedicalRepository.saveYTe(medical);
    }
}
