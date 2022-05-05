package com.codegym.repository;

import com.codegym.model.Email;

import java.util.List;

public interface IEmailRepository {
    List<Email> getList();
    void save(Email email);
}
