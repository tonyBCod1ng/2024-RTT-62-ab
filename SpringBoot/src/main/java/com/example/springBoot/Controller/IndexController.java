package com.example.springBoot.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class IndexController {
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView response = new ModelAndView("index");
        response.addObject("added", "huh?");
        return response;
    }
    @GetMapping("/SecondPage")
    public ModelAndView SecondPage() {
        ModelAndView response = new ModelAndView("SecondJSPPage");
        return response;
    }
    @GetMapping("/hirdPage")
    public ModelAndView ThirdPage() {
        ModelAndView response = new ModelAndView("ThirdsDaCharm");
        return response;
    }
}
