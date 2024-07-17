package com.example.springBoot.form;

import com.example.springBoot.database.entity.Employee;
import lombok.*;

@Getter
@Setter
@ToString

public class CreateCustomerFormBean {
    private Integer id;
    private String customerName;
    private String contactFirstname;
    private String contactLastname;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private Integer employeesId;
    private Double creditLimit;
    private int reportsTo;
}