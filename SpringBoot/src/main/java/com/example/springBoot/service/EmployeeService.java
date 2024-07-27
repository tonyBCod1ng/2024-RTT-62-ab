package com.example.springBoot.service;

import com.example.springBoot.database.dao.EmployeeDAO;
import com.example.springBoot.database.dao.OfficeDAO;
import com.example.springBoot.database.entity.Employee;
import com.example.springBoot.database.entity.Office;
import com.example.springBoot.form.CreateEmployeeFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Slf4j
@Component
public class EmployeeService {
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private OfficeDAO officeDAO;
    public Employee makeEmployee(CreateEmployeeFormBean formBean) {
            Employee employee = getEmployee(formBean);
            employeeDAO.save(employee);
            return employee;
        }

        private static Employee getEmployee(CreateEmployeeFormBean formBean) {
            Employee employee = new Employee();
            employee.setFirstname(formBean.getFirstName());
            employee.setLastname(formBean.getLastName());
            employee.setEmail(formBean.getEmail());
            employee.setExtension(formBean.getExtension());
            employee.setOfficeId(formBean.getOfficeId());
            employee.setJobTitle(formBean.getJobTitle());
            employee.setReportsTo(formBean.getReportsTo());
            employee.setProfileImageUrl("/public/images/"+ formBean.getFile().getOriginalFilename());
            return employee;
        }
    }
