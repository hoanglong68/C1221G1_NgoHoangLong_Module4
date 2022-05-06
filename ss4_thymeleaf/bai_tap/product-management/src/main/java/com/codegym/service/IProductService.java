package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProductList();

    void createProduct(Product product);

    Product findProductById(String id);

    void removeProduct(Product product);
}
