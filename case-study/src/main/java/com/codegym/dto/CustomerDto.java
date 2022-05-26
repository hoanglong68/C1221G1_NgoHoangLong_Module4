package com.codegym.dto;

import com.codegym.model.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.*;
import java.time.LocalDate;

public class CustomerDto implements Validator {
    private Integer customerId;
    @NotEmpty(message = "Not empty !")
    @Pattern(regexp = "^(KH-)\\d{4}$", message = "base on KH-XXXX (x is 0-9 !)")
    private String customerCode;

    @NotEmpty(message = "Not empty !")
    private String customerName;

    private String customerDateOfBirth;

    @NotNull(message = "pls confirm your gender !")
    private Integer customerGender;

    @NotEmpty(message = "Not empty !")
    @Pattern(regexp = "^\\d{9}|\\d{12}$", message = "9 or 12 number")
    private String customerIdCard;

    @NotEmpty(message = "Not empty !")
    @Pattern(regexp = "((\\(84\\)\\+(90))|(\\(84\\)\\+(91))|(090)|(091))\\d{7}",
            message = "090xxxxxxx,091xxxxxxx ,(84)+90xxxxxxx,(84)+91xxxxxxx")
    private String customerPhone;

    @NotEmpty(message = "Not empty !")
    @Email(message = "base on ...@dot...")
    private String customerEmail;

    @NotEmpty(message = "Not empty !")
    private String customerAddress;

    @NotNull(message = "pls confirm your customer type !")
    private CustomerType customerType;

    private boolean customerStatus = true;


    public boolean isCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(boolean customerStatus) {
        this.customerStatus = customerStatus;
    }

    public CustomerDto() {
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerDateOfBirth() {
        return customerDateOfBirth;
    }

    public void setCustomerDateOfBirth(String customerDateOfBirth) {
        this.customerDateOfBirth = customerDateOfBirth;
    }

    public Integer getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        if ("".equals(customerDto.customerDateOfBirth)) {
            errors.rejectValue("customerDateOfBirth", "dob.checkEmpty", "giảng làm !");
        } else if (!LocalDate.parse(customerDto.customerDateOfBirth).isBefore(LocalDate.now())) {
            errors.rejectValue("customerDateOfBirth", "dob.checkDate", "giảng làm !");
        }
    }
}
