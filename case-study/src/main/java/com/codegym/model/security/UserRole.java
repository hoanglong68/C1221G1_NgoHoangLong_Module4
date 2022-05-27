package com.codegym.model.security;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserRole {
    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "User_Id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "Role_Id", nullable = false)
    private Role role;
}
