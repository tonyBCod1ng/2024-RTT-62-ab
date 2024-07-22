package com.example.springBoot.database.dao;
import  com.example.springBoot.database.entity.Order;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface OrderDAO extends JpaRepository<Order, String> {
    @Query("select o from Order o where concat(o.id, o.orderDate, o.customerId) like concat('%', :name, '%') ")
    List<Order> findByCustomerId(String name);
    Order findOrderById(int id);

    @Query(value = "select o.id as order_id, o.order_date, od.quantity_ordered, p.product_name, p.id as product_id, od.price_each, od.quantity_ordered * od.quantity_ordered as total " +
            "from orderdetails od, products p, orders o " +
            "where o.id = :id and :id = od.order_id " +
            "order by order_id;", nativeQuery = true)
     List<Map<String, Object>> getOrderDetails(Integer id);

    /*-- write a query that shows the order, order date, the quantity ordered, and the product name
    select o.id as order_id, o.order_date, od.quantity_ordered, p.product_name, p.id as product_id
    from orderdetails od, products p, orders o
    where od.product_id = p.id and o.id = od.order_id
    order by order_id;*/
}
