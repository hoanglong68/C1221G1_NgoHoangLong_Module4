package com.codegym.service;

import com.codegym.model.Email;
import com.codegym.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements IEmailService {
    @Autowired
    IEmailRepository iEmailRepository;

    @Override
    public List<Email> getList() {
        return iEmailRepository.getList();
    }

    @Override
    public void save(Email email) {
        iEmailRepository.save(email);
    }
}
