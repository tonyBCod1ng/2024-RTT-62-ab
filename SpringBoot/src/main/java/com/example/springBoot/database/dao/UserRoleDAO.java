package com.example.springBoot.database.dao;

import com.example.springBoot.database.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleDAO extends JpaRepository<UserRole, Integer> {

}
