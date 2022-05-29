package com.codegym.repository;

import com.codegym.model.ProductOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductOrderRepository extends JpaRepository<ProductOrder,Integer> {
    Page<ProductOrder> findAllByProductOrderBuyDateBetween(String beforeBuyDate, String afterBuyDate, Pageable pageable);
    Page<ProductOrder> findAllByProductOrderBuyDateBefore(String beforeBuyDate, Pageable pageable);
    Page<ProductOrder> findAllByProductOrderBuyDateAfter(String afterBuyDate, Pageable pageable);
    @Query(value = "select * from product_order p_o inner join product p on p_o.product_id = p.product_id group by p_o.product_order_id order by p_o.product_order_quantity * p.product_price desc limit :limitPage",
            nativeQuery = true)
    List<ProductOrder> findTopTotalMoney(Integer limitPage);
}
