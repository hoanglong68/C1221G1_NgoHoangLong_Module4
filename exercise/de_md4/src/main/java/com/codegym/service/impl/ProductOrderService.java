package com.codegym.service.impl;

import com.codegym.model.ProductOrder;
import com.codegym.repository.IProductOrderRepository;
import com.codegym.service.IProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderService implements IProductOrderService {
    @Autowired
    private IProductOrderRepository productOrderRepository;

    @Override
    public Page<ProductOrder> findAll(Pageable pageable) {
        return productOrderRepository.findAll(pageable);
    }

    @Override
    public Page<ProductOrder> findAllByBuyDate(String beforeBuyDate, String afterBuyDate, Pageable pageable) {
        if (!"".equals(beforeBuyDate) && !"".equals(afterBuyDate)) {
            return productOrderRepository.findAllByProductOrderBuyDateBetween(beforeBuyDate, afterBuyDate, pageable);
        } else if ("".equals(beforeBuyDate) && !"".equals(afterBuyDate)) {
            return productOrderRepository.findAllByProductOrderBuyDateAfter(afterBuyDate, pageable);
        } else if (!"".equals(beforeBuyDate) && "".equals(afterBuyDate)) {
            return productOrderRepository.findAllByProductOrderBuyDateBefore(beforeBuyDate, pageable);
        } else {
            return productOrderRepository.findAll(pageable);
        }
    }

    @Override
    public List<ProductOrder> findTop(String limitPage) {
        return productOrderRepository.findTopTotalMoney(Integer.parseInt(limitPage));
    }

    @Override
    public ProductOrder findById(String idProduct) {
        return productOrderRepository.findById(Integer.parseInt(idProduct)).orElse(null);
    }

    @Override
    public void save(ProductOrder productOrder) {
        this.productOrderRepository.save(productOrder);
    }
}
