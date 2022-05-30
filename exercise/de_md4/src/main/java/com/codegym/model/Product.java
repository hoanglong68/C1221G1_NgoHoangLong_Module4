package com.codegym.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(generator = "id-generator")
    @GenericGenerator(name = "id-generator",parameters = @Parameter(name = "prefix",value = "p"),strategy = "com.codegym.util.IdentityCodeGenerator")
    private String productId;
    private String productName;
    @Column(columnDefinition = "DOUBLE")
    private String productPrice;
    private String productStatus;
    @ManyToOne
    @JoinColumn(name = "product_type_id", referencedColumnName = "productTypeId")
    private ProductType productType;
    
    @OneToMany(mappedBy = "product")
    private List<ProductOrder> productOrderList;

    public List<ProductOrder> getProductOrderList() {
        return productOrderList;
    }

    public void setProductOrderList(List<ProductOrder> productOrderList) {
        this.productOrderList = productOrderList;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
