package com.example.springBoot.Controller;

import com.example.springBoot.database.dao.CustomerDAO;
import com.example.springBoot.database.dao.EmployeeDAO;
import com.example.springBoot.database.entity.Customer;
import com.example.springBoot.database.entity.Employee;
import com.example.springBoot.form.CreateCustomerFormBean;
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
@RequestMapping("/customers")
class CustomerController {
    @Autowired
    private CustomerDAO customerDAO;
    @Autowired
    private EmployeeDAO employeeDAO;

    @GetMapping("/")
    public ModelAndView customer(@RequestParam(required = false) String name) {
        ModelAndView response = new ModelAndView("customers/customerSearch");
        List<Customer> customers = customerDAO.findCustomerByCustomerName(name);
        response.addObject("customers", customers);
        response.addObject("name", name);
        return response;
    }
    @GetMapping("/customer/{id}")
    public ModelAndView customerItem(@PathVariable int id) {
        ModelAndView response = new ModelAndView("customers/customerItem");
        Customer customer = customerDAO.findCustomerById(id);
        response.addObject("customer", customer);
        return response;
    }
    @GetMapping("/create")
    public ModelAndView createCustomer() {
        ModelAndView response = new ModelAndView("customers/create");
        List<Employee> employees = employeeDAO.findAll();
        response.addObject("reportsTo", employees);
        return response;
    }
    @GetMapping("/createSubmit")
    public ModelAndView createCustomerSubmit(CreateCustomerFormBean formBean) {
        ModelAndView response = new ModelAndView("customers/createSubmit");
        Customer customer = new Customer();
        Employee employee = employeeDAO.findEmployeeById(formBean.getReportsTo());
        customer.setCustomerName(formBean.getCustomerName());
        customer.setCity(formBean.getCity());
        customer.setCountry(formBean.getCountry());
        customer.setState(formBean.getState());
        customer.setAddressLine1(formBean.getAddressLine1());
        customer.setAddressLine2(formBean.getAddressLine2());
        customer.setPostalCode(formBean.getPostalCode());
        customer.setContactFirstname(formBean.getContactFirstname());
        customer.setContactLastname(formBean.getContactLastname());
        customer.setPhone(formBean.getPhone());
        customer.setEmployee(employee);
        customer.setCreditLimit(formBean.getCreditLimit());
        customerDAO.save(customer);
        response.setViewName("redirect:/customers/customer/" + customer.getId());
        return response;
    }
}
