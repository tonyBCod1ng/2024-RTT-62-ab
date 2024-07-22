package com.example.springBoot.Controller;

import com.example.springBoot.database.dao.OrderDAO;
import com.example.springBoot.database.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

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
    @GetMapping("/order/{id}")
    ModelAndView OrderItem(@PathVariable(required = false) int id){
        ModelAndView response = new ModelAndView("orderItem");
        Order order = orderDAO.findOrderById(id);
        response.addObject("order", order);
        return response;
    }

    @GetMapping("/order/detail")
    ModelAndView OrderDetail(@RequestParam(required = false) int id){
        ModelAndView response = new ModelAndView("od");
        List<Map<String, Object>> orderDetails = orderDAO.getOrderDetails(id);
        response.addObject("orderDetails", orderDetails);
        return response;
    }
}
