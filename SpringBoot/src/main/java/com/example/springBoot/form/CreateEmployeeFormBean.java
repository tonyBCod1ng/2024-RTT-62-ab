package com.example.springBoot.form;

import com.example.springBoot.database.entity.Employee;
import com.example.springBoot.validation.EmailUniqueCheck;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString
public class CreateEmployeeFormBean {
    private int id;
    private int officeId;
    @Length(max = 100, message = "Email must be less than 100 characters")
    @NotEmpty(message = "Email is required.")
    //@EmailUniqueCheck(message = "Email is in use.")
    @Email(regexp = "^[\\w\\-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$", message = "Please enter valid Email")
    private String email;

    @Length(max = 50, message = "Firstname must be less than 50 characters")
    @NotEmpty(message = "First Name is required.")
    private String FirstName;

    @Length(max = 50, message = "Lastname must be less than 50 characters")
    @NotEmpty(message = "Last Name is required.")
    private String LastName;

    private String jobTitle;
    @Length(max = 10, message = "Must be a maximum of 10 characters")
    @NotEmpty(message = "Must Provide an Extension")
    private String extension;
    private int reportsTo;
    private Employee employee;
}
