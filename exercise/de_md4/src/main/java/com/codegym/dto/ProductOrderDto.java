package com.codegym.dto;

import com.codegym.model.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class ProductOrderDto implements Validator {
    private Integer productOrderId;
    private String productOrderBuyDate;
    @Positive(message = "Must be positive number !")
    private String productOrderQuantity;
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
        ProductOrderDto productOrderDto = (ProductOrderDto) target;
        if ("".equals(productOrderDto.productOrderBuyDate)){
            errors.rejectValue("productOrderBuyDate","day.checkEmpty","giảng làm !");
        }
        try{
            if (!LocalDate.parse(productOrderDto.productOrderBuyDate).isAfter(LocalDate.now())){
                errors.rejectValue("productOrderBuyDate","day.checkDate","giảng làm !");
            }
        }catch (Exception e){
            errors.rejectValue("productOrderBuyDate","day.valid","giảng làm !");
        }
    }
}
