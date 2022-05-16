package com.codegym.dto;

import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;

@Data
public class ProductDto implements Validator {
    Integer id;
    @NotEmpty(message = "must be not empty !")
    String name;

    @NotEmpty(message = "must be not empty !")
    String price;

    @NotEmpty(message = "must be not empty !")
    String description;

    @NotEmpty(message = "must be not empty !")
    String manufacturer;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
