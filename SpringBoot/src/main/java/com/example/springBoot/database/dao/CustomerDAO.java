package com.example.springBoot.database.dao;

import com.example.springBoot.database.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerDAO extends JpaRepository<Customer, String> {
    @Query("select c from Customer c where concat(c.id, '', c.customerName, '', c.id) like concat('%', :name, '%') ")
    List<Customer> findCustomerByCustomerName(String name);
    Customer findCustomerById(Integer id);
}
