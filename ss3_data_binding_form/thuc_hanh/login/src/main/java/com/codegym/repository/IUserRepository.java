package com.codegym.repository;

import com.codegym.model.Login;
import com.codegym.model.User;

public interface IUserRepository {
     User checkLogin(Login login);
}
