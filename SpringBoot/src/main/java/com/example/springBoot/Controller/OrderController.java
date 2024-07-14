package com.example.springBoot.Controller;

import com.example.springBoot.database.dao.OrderDAO;
import com.example.springBoot.database.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
 class OrderController {
    @Autowired
    private OrderDAO orderDAO;
    @GetMapping("/")
    ModelAndView Orders(@RequestParam(required = false) String name) {
        ModelAndView response = new ModelAndView("order");
        List<Order> orders =  orderDAO.findByCustomerId(name);

        response.addObject("orders", orders);
        response.addObject("name", name);
        return response;
    }
    @GetMapping("/order")
    ModelAndView OrderItem(@RequestParam(required = false) int name){
        ModelAndView response = new ModelAndView("orderItem");
        Order order = orderDAO.findOrderById(name);
        response.addObject("order", order);
        return response;
    }
}
