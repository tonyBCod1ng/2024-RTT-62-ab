package com.example.springBoot.Controller;

import com.example.springBoot.database.dao.EmployeeDAO;
import com.example.springBoot.database.entity.Employee;
import com.example.springBoot.form.CreateEmployeeFormBean;
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
        ModelAndView response = new ModelAndView("employees/employeeSearch");
        List<Employee> employees = employeeDAO.findByFirstname(name);
        response.addObject("employees", employees);
        response.addObject("name", name);
        return response;
    }
    @GetMapping("/employee/{id}")
    public ModelAndView EmployeeItem(@PathVariable int id) {
        ModelAndView response = new ModelAndView("employees/employeeItem");
        Employee employee = employeeDAO.findEmployeeById(id);
        response.addObject("employee", employee);
        return response;
    }
    @GetMapping("/create")
     ModelAndView createEmployee(@RequestParam(required = false) Employee newEmployee) {
        ModelAndView response = new ModelAndView("employees/create");
        return response;
    }
    @GetMapping("/createSubmit")
    ModelAndView createEmployeeSubmit(@RequestParam(required = false) CreateEmployeeFormBean formBean) {
        ModelAndView response = new ModelAndView("employees/createSubmit");

        return null;
    }
}
