package com.codegym.dto;

import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class SongDto implements Validator {

    private Integer id;

    @NotEmpty(message = "Name Song must be not empty !")
    @Size(max = 800, message = "Name Song do not over 800 character !")
    @Pattern(regexp = "^([\\w]*[\\s]*[\\w]*)*$", message = "Name Song can not contain special character")
    private String nameSong;

    @NotEmpty(message = "Name Singer must be not empty !")
    @Size(max = 300, message = "Name Singer do not over 300 character !")
    @Pattern(regexp = "^([\\w]*[\\s]*[\\w]*)*$", message = "Name Singer can not contain special character")
    private String nameSinger;

    @NotEmpty(message = "type song must be not empty !")
    @Size(max = 1000, message = "do not over 1000 character !")
    @Pattern(regexp = "^([\\w]*[\\s]*[\\w]*[,]*)*$", message = "Type Song can not contain special character except: \", \")")

    private String typeSong;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    }
}
