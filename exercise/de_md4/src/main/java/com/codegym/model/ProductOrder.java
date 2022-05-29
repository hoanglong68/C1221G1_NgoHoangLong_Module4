package com.codegym.model;

import javax.persistence.*;

@Entity
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productOrderId;
    @Column(columnDefinition = "DATE")
    private String productOrderBuyDate;
    @Column(columnDefinition = "INT")
    private String productOrderQuantity;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "productId")
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
}
