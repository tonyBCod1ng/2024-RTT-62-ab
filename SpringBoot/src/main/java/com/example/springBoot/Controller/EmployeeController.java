package com.example.springBoot.Controller;

import com.example.springBoot.database.dao.EmployeeDAO;
import com.example.springBoot.database.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/employees")
 class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping("/")
    public ModelAndView Employee(@RequestParam(required = false) String name) {
        ModelAndView response = new ModelAndView("employeeSearch");
        List<Employee> employees = employeeDAO.findByFirstname(name);
        response.addObject("employees", employees);
        response.addObject("name", name);
        return response;
    }
    @GetMapping("/employee/{id}")
    public ModelAndView EmployeeItem(@PathVariable int id) {
        ModelAndView response = new ModelAndView("employeeItem");
        Employee employee = employeeDAO.findEmployeeById(id);
        response.addObject("employee", employee);
        return response;
    }
}
