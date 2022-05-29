package com.codegym.service;

import com.codegym.model.ProductOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IProductOrderService {
    Page<ProductOrder> findAll(Pageable pageable);

    Page<ProductOrder> findAllByBuyDate(String beforeBuyDate,String afterBuyDate,Pageable pageable);

    List<ProductOrder> findTop(String limitPage);

    ProductOrder findById(String idProduct);

    void save(ProductOrder productOrder);
}
