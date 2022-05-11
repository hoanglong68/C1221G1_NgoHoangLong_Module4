package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> getProductList(String name, Pageable pageable);

    Product findProductById(Integer id);

    void removeProduct(Product product);

    void saveProduct(Product product);

//    List<Product> findProductByName(String search);
}
