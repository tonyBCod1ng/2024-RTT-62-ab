package com.example.springBoot.database.dao;

import com.example.springBoot.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product, Long> {

    Product findById(Integer id);


}
