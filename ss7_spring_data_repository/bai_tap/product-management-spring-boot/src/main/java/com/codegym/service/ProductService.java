package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<Product> getProductList(String name, Pageable pageable) {
        return iProductRepository.findAllByNameContainingOrderByNameAsc(name, pageable);
    }

    @Override
    public Product findProductById(Integer id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public void removeProduct(Product product) {
        iProductRepository.delete(product);
    }

    @Override
    public void saveProduct(Product product) {
        iProductRepository.save(product);
    }

//    @Override
//    public List<Product> findProductByName(String search) {
//        return iProductRepository.findProductByName(search);
//    }
}
