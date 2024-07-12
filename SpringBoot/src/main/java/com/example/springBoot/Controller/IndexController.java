package com.example.springBoot.Controller;

import com.example.springBoot.database.dao.ProductDAO;
import com.example.springBoot.database.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
 class IndexController {
    @Autowired
    private ProductDAO productDAO;

    @GetMapping("/")
     ModelAndView index() {
        ModelAndView response = new ModelAndView("index");
        log.debug("info level");
        log.info("info level");
        log.warn("warn level");
        log.error("error level");
        return response;
    }
    @GetMapping("/inventory")
     ModelAndView inventory(@RequestParam(required = false) Integer id) {
        List<Product> products = productDAO.findAll();
        ModelAndView response = new ModelAndView("inventory");
        response.addObject("products", products);
        return response;
    }
    @GetMapping("/item/{id}")
     ModelAndView inventoryPathVar(@PathVariable(name = "id") Integer productId) {
        ModelAndView response = null;
        Product product = productDAO.findById(productId);
        if (productId > 110) {
            product = productDAO.findById(110);
        }
        response = new ModelAndView("item");
        response.addObject("product", product);
        return response;
    }

    @GetMapping("/SecondPage")
     ModelAndView SecondPage() {
        ModelAndView response = new ModelAndView("SecondJSPPage");
        return response;
    }

    @GetMapping("/hirdPage")
     ModelAndView ThirdPage() {
        ModelAndView response = new ModelAndView("ThirdsDaCharm");
        return response;
    }
    @GetMapping("/homework")
    public ModelAndView Homework(@RequestParam(required = false) Integer id) {
        ModelAndView response = new ModelAndView("homework");
        return response;
    }
}
