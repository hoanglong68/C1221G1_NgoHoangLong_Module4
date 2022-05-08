package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

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
        product.setId(String.valueOf(Math.round(Math.random() * 1000)));
        productList.add(product);
    }

    @Override
    public Product findProductById(String id) {
        Product product = null;
        for (Product value : productList) {
            if (value.getId().equals(id)) {
                product = value;
                break;
            }
        }
        return product;
    }

    @Override
    public void removeProduct(Product product) {
        productList.remove(product);
    }

    @Override
    public void saveProduct(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(product.getId())) {
                productList.set(i, product);
                break;
            }
        }
    }

    @Override
    public List<Product> findProductByName(String search) {
        List<Product> productFindList = new ArrayList<>();
        for (Product value : productList) {
            if (value.getName().contains(search)) {
                productFindList.add(value);
            }
        }
        return productFindList;
    }
}
