package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    public static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product("1", "long", "30000", "dep trai", "vn"));
        productList.add(new Product("2", "huu", "50000", "dep gai", "tq"));
        productList.add(new Product("3", "my", "60000", "dep gai", "an do"));
    }

    @Override
    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public void createProduct(Product product) {
        productList.add(product);
    }

    @Override
    public Product findProductById(String id) {
        return productList.get(Integer.parseInt(id));
    }

    @Override
    public void removeProduct(Product product) {
        productList.remove(product);
    }
}
