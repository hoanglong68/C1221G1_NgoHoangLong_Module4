package com.codegym.dto;

import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;


@Data
public class UserDto implements Validator {
    private Integer id;
    @NotEmpty(message = "must be not empty")
    @Pattern(regexp = "^[A-Za-z]{4,45}$", message = "at least 4 and max character is 45")
    private String firstName;
    @NotEmpty(message = "must be not empty")
    @Pattern(regexp = "^[A-Za-z]{4,45}$", message = "at least 4 and max character is 45")
    private String lastName;

    private String phoneNumber;

    private String age;
    @NotEmpty(message = "must be not empty")
    @Email(message = "email must be depend on form: ...@..dot...")
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if (!userDto.phoneNumber.matches("^\\d{10}$")) {
            errors.rejectValue("phoneNumber", "phoneNumber.size");
        }
        try {
            if (Integer.parseInt(userDto.age) < 18) {
                errors.rejectValue("age", "age.check18");
            }
        } catch (NumberFormatException numberFormatException) {
            errors.rejectValue("age", "age.checkFormat");
        }
    }
}
