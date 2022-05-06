package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepository iProductRepository;

    @Override
    public List<Product> getProductList() {
        return iProductRepository.getProductList();
    }

    @Override
    public void createProduct(Product product) {
        iProductRepository.createProduct(product);
    }

    @Override
    public Product findProductById(String id) {
        return iProductRepository.findProductById(id);
    }

    @Override
    public void removeProduct(Product product) {
        iProductRepository.removeProduct(product);
    }
}
