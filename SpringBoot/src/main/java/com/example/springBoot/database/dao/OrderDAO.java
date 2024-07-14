package com.example.springBoot.database.dao;
import  com.example.springBoot.database.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order, String> {
    @Query("select o from Order o where concat(o.id, o.orderDate, o.customerId) like concat('%', :name, '%') ")
    List<Order> findByCustomerId(String name);
    Order findOrderById(int id);
}
