package com.example.springBoot.validation;

import ch.qos.logback.classic.Logger;
import com.example.springBoot.database.dao.EmployeeDAO;
import com.example.springBoot.database.entity.Employee;
import com.example.springBoot.validation.EmailUniqueCheck;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

  class EmailUniqueCheckImpl implements ConstraintValidator<EmailUniqueCheck, String> {

    @Autowired
    private EmployeeDAO employeeDao;


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // a test should only do one thing, so we should check for null first
        // always return true on null ... this is a pattern in creating test cases within JSR 303
        // its a good practice to always return true when your input value is null or empty
        if (StringUtils.isEmpty(value)) {
            return true;
        }

        //UserMSQL user = userService.findByEmailIgnoreCase(value);
        Employee employee = employeeDao.findByEmailIgnoreCase(value);

        // this validation returns true when the email is NOT in the database
        return (employee == null);
    }


}