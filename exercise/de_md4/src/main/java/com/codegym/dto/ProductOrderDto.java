package com.codegym.dto;

import com.codegym.model.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductOrderDto implements Validator {
    private Integer productOrderId;
    @NotEmpty(message = "do not empty !")
    private String productOrderBuyDate;
    @NotEmpty(message = "do not empty !")
    private String productOrderQuantity;
    @NotNull(message = "pls confirm product !")
    private Product product;

    public Integer getProductOrderId() {
        return productOrderId;
    }

    public void setProductOrderId(Integer productOrderId) {
        this.productOrderId = productOrderId;
    }

    public String getProductOrderBuyDate() {
        return productOrderBuyDate;
    }

    public void setProductOrderBuyDate(String productOrderBuyDate) {
        this.productOrderBuyDate = productOrderBuyDate;
    }

    public String getProductOrderQuantity() {
        return productOrderQuantity;
    }

    public void setProductOrderQuantity(String productOrderQuantity) {
        this.productOrderQuantity = productOrderQuantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
