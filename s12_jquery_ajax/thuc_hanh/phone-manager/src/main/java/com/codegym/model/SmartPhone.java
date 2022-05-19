package com.codegym.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "smartphones")
public class SmartPhone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String producer;
    private String model;
    private double price;
}
