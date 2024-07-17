package com.example.springBoot.database.dao;

import com.example.springBoot.database.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfficeDAO extends JpaRepository<Office, Integer> {
    List<Office> findAll();
    Office findOfficeById(int id);
}
