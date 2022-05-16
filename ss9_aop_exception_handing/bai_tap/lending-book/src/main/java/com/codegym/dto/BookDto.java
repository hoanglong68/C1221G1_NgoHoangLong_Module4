package com.codegym.dto;

import com.codegym.model.BookLending;
import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;

@Data
public class BookDto implements Validator {
    private Integer idBook;
    private String nameBook;
    private String author;
    private Integer count;
    private BookLending bookLending;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
