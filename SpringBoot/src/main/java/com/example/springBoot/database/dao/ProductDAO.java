package com.example.springBoot.database.dao;

import com.example.springBoot.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, String> {

    Product findById(Integer id);

@Query("select p from Product p where p.productName like concat('%', :name, '%') ")
List<Product> findByName(String name);

}
