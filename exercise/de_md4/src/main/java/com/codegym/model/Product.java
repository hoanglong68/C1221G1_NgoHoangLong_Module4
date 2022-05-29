package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
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

    public Integer getProductId() {
        return productId;
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

    public void setProductId(Integer productId) {
        this.productId = productId;
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
