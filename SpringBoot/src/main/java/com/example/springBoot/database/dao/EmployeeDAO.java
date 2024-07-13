package com.example.springBoot.database.dao;

import com.example.springBoot.database.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee, String> {
    @Query("select e from Employee e where concat(e.firstname,'',  e.lastname, '', e.id) like concat('%', :name, '%') ")
    List<Employee> findByFirstname(String name);
    Employee findEmployeeById(int id);
}
