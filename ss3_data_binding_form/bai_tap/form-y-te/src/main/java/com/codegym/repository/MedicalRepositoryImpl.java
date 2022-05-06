package com.codegym.repository;

import com.codegym.model.Medical;
import org.springframework.stereotype.Repository;

@Repository
public class MedicalRepositoryImpl implements IMedicalRepository {
    public Medical medical = null;

    @Override
    public Medical getYTe() {
        return medical;
    }

    public void setMedical(Medical medical) {
        this.medical = medical;
    }

    @Override
    public void saveYTe(Medical medical) {
        setMedical(medical);
    }
}
