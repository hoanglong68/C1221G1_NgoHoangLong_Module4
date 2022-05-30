package com.codegym.repository;

import com.codegym.model.ProductOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductOrderRepository extends JpaRepository<ProductOrder,Integer> {
    Page<ProductOrder> findAllByProductOrderBuyDateBetween(String beforeBuyDate, String afterBuyDate, Pageable pageable);
    Page<ProductOrder> findAllByProductOrderBuyDateBefore(String beforeBuyDate, Pageable pageable);
    Page<ProductOrder> findAllByProductOrderBuyDateAfter(String afterBuyDate, Pageable pageable);
    @Query(value = "select product_order_id, product_order_buy_date, product_order_quantity,  p.product_id, product_name, product_price, product_status, product_type_id,\n" +
            "       (po.product_order_quantity * p.product_price) as total\n" +
            "from product_order po inner join product p\n" +
            "on po.product_id = p.product_id\n" +
            "group by po.product_order_id\n" +
            "order by total desc",
            countQuery = "select product_order_id, product_order_buy_date, product_order_quantity,  p.product_id, product_name, product_price, product_status, product_type_id,\n" +
                    "       (po.product_order_quantity * p.product_price) as total\n" +
                    "from product_order po inner join product p\n" +
                    "on po.product_id = p.product_id\n" +
                    "group by po.product_order_id\n" +
                    "order by total desc",
            nativeQuery = true)

    Page<ProductOrder> findTopTotalMoney(Pageable pageable);
}
