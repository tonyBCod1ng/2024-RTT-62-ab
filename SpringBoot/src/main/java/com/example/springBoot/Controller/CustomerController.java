package com.example.springBoot.Controller;

import com.example.springBoot.database.dao.CustomerDAO;
import com.example.springBoot.database.entity.Customer;
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

    @GetMapping("/")
    public ModelAndView customer(@RequestParam(required = false) String name) {
        ModelAndView response = new ModelAndView("customer");
        List<Customer> customers = customerDAO.findCustomerByCustomerName(name);
        response.addObject("customers", customers);
        response.addObject("name", name);
        return response;
    }
    @GetMapping("/customer/{id}")
    public ModelAndView customerItem(@PathVariable int id) {
        ModelAndView response = new ModelAndView("customerItem");
        Customer customer = customerDAO.findCustomerById(id);
        response.addObject("customer", customer);
        return response;
    }
}
