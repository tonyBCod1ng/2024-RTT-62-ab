package com.example.springBoot.Controller;

import com.example.springBoot.database.dao.ProductDAO;
import com.example.springBoot.database.entity.Product;
import com.example.springBoot.form.CreateProductFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
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
    ModelAndView inventory(@RequestParam(required = false) String search) {
        List<Product> products = productDAO.findByName(search);
        ModelAndView response = new ModelAndView("inventory/inventory");
        response.addObject("products", products);
        response.addObject("name", search);
        return response;
    }

    @GetMapping("inventory/item/{id}")
    ModelAndView inventoryPathVar(@PathVariable(name = "id") Integer productId) {
        ModelAndView response = new ModelAndView("inventory/item");
        Product product = productDAO.findById(productId);

        response.addObject("product", product);
        return response;
    }

    @GetMapping("/inventory/item/create")
    ModelAndView createInventory() {
        ModelAndView response = new ModelAndView("/inventory/create");
        return response;
    }

    @GetMapping("/inventory/item/edit/{id}")
    ModelAndView editInventory(@PathVariable(name = "id") Integer productId) {
        ModelAndView response = new ModelAndView("/inventory/create");
        if (productId != null) {
            Product product = productDAO.findById(productId);
            if (product != null) {
                CreateProductFormBean formBean = new CreateProductFormBean();
                formBean.setId(product.getId());
                formBean.setProductCode(product.getProductCode());
                formBean.setProductName(product.getProductName());
                formBean.setProductDescription(product.getProductDescription());
                formBean.setProductlineId(product.getProductlineId());
                formBean.setBuyPrice(product.getBuyPrice());
                formBean.setProductScale(product.getProductScale());
                formBean.setQuantityInStock(product.getQuantityInStock());
                formBean.setMsrp(product.getMsrp());
                formBean.setProductVendor(product.getProductVendor());
                response.addObject("form", formBean);
            }
        }
        return response;
    }

    @GetMapping("/inventory/item/createSubmit")
    ModelAndView editInventorySubmit(CreateProductFormBean formBean) {
        ModelAndView response = new ModelAndView("inventory/createSubmit");
        Product product = productDAO.findById(formBean.getId());
        if (product == null) {
            product = new Product();
        }
        product.setProductCode(formBean.getProductCode());
        product.setProductName(formBean.getProductName());
        product.setProductDescription(formBean.getProductDescription());
        product.setProductlineId(formBean.getProductlineId());
        product.setBuyPrice(formBean.getBuyPrice());
        product.setProductScale(formBean.getProductScale());
        product.setQuantityInStock(formBean.getQuantityInStock());
        product.setMsrp(formBean.getMsrp());
        product.setProductVendor(formBean.getProductVendor());
        productDAO.save(product);
        response.addObject(formBean);
        response.setViewName("redirect:http://localhost:8080/inventory/item/" + product.getId());
        return response;
    }
}

