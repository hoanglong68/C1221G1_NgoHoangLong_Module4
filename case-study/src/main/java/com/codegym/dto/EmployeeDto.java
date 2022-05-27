package com.codegym.dto;

import com.codegym.model.employee.Division;
import com.codegym.model.employee.EducationDegree;
import com.codegym.model.employee.Position;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class EmployeeDto implements Validator {
    private Integer employeeId;

    @NotEmpty(message = "Not empty !")
    private String employeeName;

    private String employeeDateOfBirth;

    @NotEmpty(message = "Not empty !")
    @Pattern(regexp = "^\\d{9}|\\d{12}$", message = "9 or 12 number")
    private String employeeIdCard;

    @Positive(message = "must be positive number !")
    private Double employeeSalary;

    @NotEmpty(message = "Not empty !")
    @Pattern(regexp = "((\\(84\\)\\+(90))|(\\(84\\)\\+(91))|(090)|(091))\\d{7}",
            message = "090xxxxxxx,091xxxxxxx ,(84)+90xxxxxxx,(84)+91xxxxxxx")
    private String employeePhone;

    @NotEmpty(message = "Not empty !")
    @Email(message = "base on ...@dot...")
    private String employeeEmail;

    @NotEmpty(message = "Not empty !")
    private String employeeAddress;

    @NotNull(message = "pls confirm your position !")
    private Position position;

    @NotNull(message = "pls confirm your division !")
    private Division division;

    @NotNull(message = "pls confirm your degree !")
    private EducationDegree educationDegree;

    private boolean employeeStatus = true;

    public boolean isEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(boolean employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public EmployeeDto() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDateOfBirth() {
        return employeeDateOfBirth;
    }

    public void setEmployeeDateOfBirth(String employeeDateOfBirth) {
        this.employeeDateOfBirth = employeeDateOfBirth;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        if ("".equals(employeeDto.employeeDateOfBirth)) {
            errors.rejectValue("employeeDateOfBirth", "dob.checkEmpty", "giảng làm !");
        } else if (!LocalDate.parse(employeeDto.employeeDateOfBirth).isBefore(LocalDate.now())) {
            errors.rejectValue("employeeDateOfBirth", "dob.checkDate", "giảng làm !");
        }
    }
}