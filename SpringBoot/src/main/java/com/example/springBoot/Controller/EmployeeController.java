package com.example.springBoot.Controller;

import com.example.springBoot.database.dao.EmployeeDAO;
import com.example.springBoot.database.dao.OfficeDAO;
import com.example.springBoot.database.entity.Employee;
import com.example.springBoot.database.entity.Office;
import com.example.springBoot.form.CreateEmployeeFormBean;
import jakarta.validation.Valid;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.util.*;

@Slf4j
@Controller
@RequestMapping("/employees")
 class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
private OfficeDAO officeDAO;
    @Autowired
    private View error;

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
        if (employee.getReportsTo() == null) {
            employee.setReportsTo(0);
        }
        Employee manager = employeeDAO.findEmployeeById(employee.getReportsTo());
        response.addObject("manager", manager);
        response.addObject("employee", employee);
        return response;
    }
    @GetMapping("/create")
     ModelAndView createEmployee(@RequestParam(required = false) Employee newEmployee) {
        String manager = "Manager";
        String vpSales = "VP Sales";
        String vpMarketing = "VP Marketing";
        String salesManagerAPAC = "Sales Manager (APAC)";
        String salesManagerEMEA = "Sales Manager (EMEA)";
        String salesManagerNA = "Sales Manager (NA)";
        String salesMarketing = "Sales Marketing";
        String president = "President";
        List<String> titles = new ArrayList<>();
        titles.add(vpSales);
        titles.add(vpMarketing);
        titles.add(salesManagerAPAC);
        titles.add(salesManagerEMEA);
        titles.add(salesManagerNA);
        titles.add(salesMarketing);
        titles.add(president);
        titles.add(manager);
        List<Employee> reportsTo = new ArrayList<>();
        List<Employee> allEmployees = employeeDAO.findAll();
        for (Employee employee : allEmployees) {
            if(titles.contains(employee.getJobTitle())){
                reportsTo.add(employee);
            } else if (employee.getId() == 1621) {
                reportsTo.add(employee);
            }
        }
        List<Office> officeList = officeDAO.findAll();
        Collections.sort(officeList, Comparator.comparing(Office::getCity));
        ModelAndView response = new ModelAndView("employees/create");
        response.addObject("offices", officeList);
        response.addObject("reportsTo", reportsTo);
        return response;
    }
    @GetMapping("/createSubmit")
    ModelAndView createEmployeeSubmit(@Valid CreateEmployeeFormBean formBean, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView("employees/createSubmit");
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }

            // we are in this part of the if statement so we know for sure that an error has occured
            // we are going to add the binding result to the model, so we can use it on the JSP page to show the user the errors
            response.addObject("bindingResult", bindingResult);

            // because the page needs the list of employees for the drop down we need to add the list of employees to the model

            String manager = "Manager";
            String vpSales = "VP Sales";
            String vpMarketing = "VP Marketing";
            String salesManagerAPAC = "Sales Manager (APAC)";
            String salesManagerEMEA = "Sales Manager (EMEA)";
            String salesManagerNA = "Sales Manager (NA)";
            String salesMarketing = "Sales Marketing";
            String president = "President";
            List<String> titles = new ArrayList<>();
            titles.add(vpSales);
            titles.add(vpMarketing);
            titles.add(salesManagerAPAC);
            titles.add(salesManagerEMEA);
            titles.add(salesManagerNA);
            titles.add(salesMarketing);
            titles.add(president);
            titles.add(manager);
            List<Employee> reportsTo = new ArrayList<>();
            List<Employee> allEmployees = employeeDAO.findAll();
            for (Employee employee : allEmployees) {
                if(titles.contains(employee.getJobTitle())){
                    reportsTo.add(employee);
                } else if (employee.getId() == 1621) {
                    reportsTo.add(employee);
                }
            }
            response.addObject("reportsTo", reportsTo);

            // we need the list of offices
            List<Office> offices = officeDAO.findAll();
            response.addObject("offices", offices);

            // im going to set the view name to be
            response.setViewName("employees/create");

            // im going to add the form to the model so that we can display the user entered data in the form
            response.addObject("form", formBean);

            return response;
        } else {
            Employee employee = new Employee();
            employee.setFirstname(formBean.getFirstName());
            employee.setLastname(formBean.getLastName());
            employee.setEmail(formBean.getEmail());
            employee.setExtension(formBean.getExtension());
            employee.setOfficeId(formBean.getOfficeId());
            employee.setJobTitle(formBean.getJobTitle());
            employee.setReportsTo(formBean.getReportsTo());
            employeeDAO.save(employee);
            response.addObject("form", formBean);
            response.setViewName("redirect:http://localhost:8080/employees/employee/" + employee.getId());
            return response;
        }
    }
}
