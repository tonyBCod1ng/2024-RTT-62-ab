package com.example.springBoot.form;
import lombok.*;
@Getter
@Setter
@ToString
public class CreateEmployeeFormBean {
   private int officeId;
    private String firstName;
    private String lastName;
    private String email;
    private String jobTitle;
    private String extension;
    private int reportsTo;
}
