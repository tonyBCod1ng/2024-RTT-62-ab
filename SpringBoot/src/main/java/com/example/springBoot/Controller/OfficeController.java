package com.example.springBoot.Controller;

import com.example.springBoot.database.dao.OfficeDAO;
import com.example.springBoot.database.entity.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/offices")
public class OfficeController {
    @Autowired
    private OfficeDAO officeDAO;
    @GetMapping("/")
    ModelAndView Office(){
        ModelAndView response = new ModelAndView();
        List<Office> offices = officeDAO.findAll();
        response.addObject("offices", offices);
        return response;
    }
}
