package com.example.springBoot.Controller;

import com.example.springBoot.database.dao.EmployeeDAO;
import com.example.springBoot.database.dao.ProductDAO;
import com.example.springBoot.database.entity.Employee;
import com.example.springBoot.database.entity.Product;
import com.example.springBoot.form.CreateEmployeeFormBean;
import com.example.springBoot.form.CreateProductFormBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
class IndexController {
    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private EmployeeDAO employeeDAO;

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

    @GetMapping("/file_upload")
    ModelAndView fileUpload(@RequestParam Integer id) {
        ModelAndView response = new ModelAndView("fileUpload");
        response.addObject("id", id);
        return response;
    }

    @PostMapping("/file_upload")
    public ModelAndView fileUploadSubmit(@RequestParam MultipartFile file, @RequestParam Integer id) {
        // this page is for another page of the website which is express as "/page-url"
        ModelAndView modelAndView = new ModelAndView("redirect:/employees/employee/" + id);

        log.debug("The file name is: " + file.getOriginalFilename());
        log.debug("The file size is: " + file.getSize());
        log.debug("The file content type is: " + file.getContentType());

        // Homework
        // use the original file name and get a substring of the last index of . to the end of the string
        // then restrict based on "jpg" or "png"
        // use the model to put an error message on the page


        // this is the location on the hard drive
        String saveFilename = "./src/main/webapp/pub/images/" + file.getOriginalFilename();

        // this Files.copy is a utility that will read the stream one chunk at a time and write it to a file.
        // first arg is the input stream to read from the uploaded file
        // 2nd is the filename where we want to write the file
        // 3rd says to overwrite if existing.
        try {
            Files.copy(file.getInputStream(), Paths.get(saveFilename), StandardCopyOption.REPLACE_EXISTING);
        } catch ( Exception e ) {
            log.error("Unable to finish reading file", e);
        }

        // we can load the record from the database based on the incoming employeeId
        Employee employee = employeeDAO.findEmployeeById(id);

        // this is the URL to get the image
        String url = "/pub/images/" + file.getOriginalFilename();
        employee.setProfileImageUrl(url);

        employeeDAO.save(employee);

        return modelAndView;
    }

}

