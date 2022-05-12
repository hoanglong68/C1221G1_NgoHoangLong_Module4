package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findAllByNameContainingOrderByNameAsc(String name, Pageable pageable);
    Page<Product> findAllByNameContainingAndDescriptionContainingAndManufacturerContainingOrderByNameAsc
            (String name , String description,String manufacturer,Pageable pageable);
}
