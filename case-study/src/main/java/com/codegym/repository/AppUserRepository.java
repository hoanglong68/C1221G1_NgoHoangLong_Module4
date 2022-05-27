package com.codegym.repository;


import com.codegym.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
