package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getProductList();

    void createProduct(Product product);

    Product findProductById(String id);

    void removeProduct(Product product);
}
