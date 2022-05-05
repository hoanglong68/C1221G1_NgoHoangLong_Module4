package com.codegym.service;

import com.codegym.model.Login;
import com.codegym.model.User;
import com.codegym.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public User checkLogin(Login login) {
        return this.iUserRepository.checkLogin(login);
    }


}
