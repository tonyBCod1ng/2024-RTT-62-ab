package com.example.springBoot.Controller;

import com.example.springBoot.database.dao.EmployeeDAO;
import com.example.springBoot.database.dao.OfficeDAO;
import com.example.springBoot.database.entity.Employee;
import com.example.springBoot.database.entity.Office;
import com.example.springBoot.form.CreateEmployeeFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/employees")
 class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
private OfficeDAO officeDAO;
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
        ModelAndView response = new ModelAndView("employees/create");
        response.addObject("offices", officeList);
        response.addObject("reportsTo", reportsTo);
        return response;
    }
    @GetMapping("/createSubmit")
    ModelAndView createEmployeeSubmit(CreateEmployeeFormBean formBean) {
        ModelAndView response = new ModelAndView("employees/createSubmit");
        Employee employee = new Employee();
        employee.setFirstname(formBean.getFirstName());
        employee.setLastname(formBean.getLastName());
        employee.setEmail(formBean.getEmail());
        employee.setExtension(formBean.getExtension());
        employee.setOfficeId(formBean.getOfficeId());
        employee.setJobTitle(formBean.getJobTitle());
        employee.setReportsTo(formBean.getReportsTo());
       employeeDAO.save(employee);
        response.setViewName("redirect:http://localhost:8080/employees/employee/" + employee.getId());
        return response;
    }
}
