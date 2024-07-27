package com.example.springBoot.Controller;

import com.example.springBoot.database.dao.EmployeeDAO;
import com.example.springBoot.database.dao.OfficeDAO;
import com.example.springBoot.database.entity.Employee;
import com.example.springBoot.database.entity.Office;
import com.example.springBoot.form.CreateEmployeeFormBean;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/employees")
class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;
    @Autowired
    private OfficeDAO officeDAO;
    @Autowired
    private View error;

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
        if (employee.getReportsTo() == null) {
            employee.setReportsTo(0);
        }
        Employee manager = employeeDAO.findEmployeeById(employee.getReportsTo());
        response.addObject("manager", manager);
        response.addObject("employee", employee);
        return response;
    }

    @GetMapping("/create")
    ModelAndView createEmployee(@RequestParam(required = false) Employee newEmployee) {
        List<Employee> reportsTo = getManagerList();
        List<Office> officeList = officeDAO.findAll();
        Collections.sort(officeList, Comparator.comparing(Office::getCity));
        ModelAndView response = new ModelAndView("employees/create");
        response.addObject("offices", officeList);
        response.addObject("reportsTo", reportsTo);
        return response;
    }
    @RequestMapping(value = "/createSubmit", method = {RequestMethod.POST, RequestMethod.GET})
    ModelAndView createEmployeeSubmit(@Valid CreateEmployeeFormBean formBean, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView("employees/createSubmit");
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }

            // we are in this part of the if statement so we know for sure that an error has occured
            // we are going to add the binding result to the model, so we can use it on the JSP page to show the user the errors
            response.addObject("bindingResult", bindingResult);

            // because the page needs the list of employees for the drop down we need to add the list of employees to the model

            List<Employee> reportsTo = getManagerList();
            response.addObject("reportsTo", reportsTo);

            // we need the list of offices
            List<Office> offices = officeDAO.findAll();
            response.addObject("offices", offices);

            // im going to set the view name to be
            response.setViewName("employees/create");

            // im going to add the form to the model so that we can display the user entered data in the form
            response.addObject("form", formBean);

            return response;
        } else {
            Employee employee = getEmployee(formBean);
            employeeDAO.save(employee);
            response.addObject("form", formBean);
            //response.setViewName("redirect:http://localhost:8080/employees/employee/" + employee.getId());
            getManagerList();
            response.setViewName("employees/createSubmit");

            return response;
        }
    }

    private static Employee getEmployee(CreateEmployeeFormBean formBean) {
        Employee employee = new Employee();
        employee.setFirstname(formBean.getFirstName());
        employee.setLastname(formBean.getLastName());
        employee.setEmail(formBean.getEmail());
        employee.setExtension(formBean.getExtension());
        employee.setOfficeId(formBean.getOfficeId());
        employee.setJobTitle(formBean.getJobTitle());
        employee.setReportsTo(formBean.getReportsTo());
        employee.setProfileImageUrl("/public/images/"+ formBean.getFile().getOriginalFilename());
        return employee;
    }

    @GetMapping("/edit/{id}")
    ModelAndView editEmployee(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("employees/create");
        List<Employee> reportsTo = getManagerList();
        response.addObject("reportsTo", reportsTo);

        // we need the list of offices
        List<Office> offices = officeDAO.findAll();
        response.addObject("offices", offices);
        if (id != null) {
            Employee employee = employeeDAO.findEmployeeById(id);
            if (employee != null) {
                CreateEmployeeFormBean formBean = new CreateEmployeeFormBean();
                formBean.setId(employee.getId());
                formBean.setFirstName(employee.getFirstname());
                formBean.setLastName(employee.getLastname());
                formBean.setEmail(employee.getEmail());
                formBean.setExtension(employee.getExtension());
                formBean.setOfficeId(employee.getOfficeId());
                formBean.setJobTitle(employee.getJobTitle());
                formBean.setProfilePicture(employee.getProfileImageUrl());
                if(employee.getReportsTo() == null) { employee.setReportsTo(0);}
                formBean.setReportsTo(employee.getReportsTo());
                response.addObject("form", formBean);
            }
        }
        return response;
    }

    private List<Employee> getManagerList() {
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
            if (titles.contains(employee.getJobTitle())) {
                reportsTo.add(employee);
            } else if (employee.getId() == 1621) {
                reportsTo.add(employee);
            }
        }
        return reportsTo;
    }

    @RequestMapping(value = "/editSubmit", method = {RequestMethod.POST, RequestMethod.GET})
    ModelAndView editEmployeeSubmit(@Valid CreateEmployeeFormBean formBean, BindingResult bindingResult) {
        ModelAndView response = new ModelAndView();
        MultipartFile file = formBean.getFile();
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Validation error : " + ((FieldError) error).getField() + " = " + error.getDefaultMessage());
            }

            // we are in this part of the if statement so we know for sure that an error has occured
            // we are going to add the binding result to the model, so we can use it on the JSP page to show the user the errors
            response.addObject("bindingResult", bindingResult);

            // because the page needs the list of employees for the drop down we need to add the list of employees to the model

            //region populate drops
            List<Employee> reportsTo = getManagerList();
            response.addObject("reportsTo", reportsTo);
            //endregion

            // we need the list of offices
            List<Office> offices = officeDAO.findAll();
            response.addObject("offices", offices);

            // im going to set the view name to be
            response.setViewName("employees/editSubmit");

            // im going to add the form to the model so that we can display the user entered data in the form
            response.addObject("form", formBean);

            return response;
        } else {
            // log out the incoming variables that are in the CreateEmployeeFormBean
            // variable name
            log.debug(formBean.toString());

            // first, I am going to take a shot at looking up the record in the database based on the incoming employeeId
            // this is from the hidden input field and is not something the user actually entered themselves
            Employee employee = employeeDAO.findEmployeeById(formBean.getId());
            if (employee == null) {
                /// this means it was not found in the database so we are going to consider this a create
                employee = new Employee();
            }
            String saveFilename = "./src/main/webapp/public/images/" + file.getOriginalFilename();

            // this Files.copy is a utility that will read the stream one chunk at a time and write it to a file.
            // first arg is the input stream to read from the uploaded file
            // 2nd is the filename where we want to write the file
            // 3rd says to overwrite if existing.
            if (formBean.getFile() != null) {
                try {
                    Files.copy(file.getInputStream(), Paths.get(saveFilename), StandardCopyOption.REPLACE_EXISTING);
                    formBean.setProfilePicture("/public/images/" + file.getOriginalFilename());
                } catch ( Exception e ) {
                    log.error("Unable to finish reading file", e);
                }
            }

                employee.setProfileImageUrl(formBean.getProfilePicture());

            employee.setEmail(formBean.getEmail());
            employee.setFirstname(formBean.getFirstName());
            employee.setLastname(formBean.getLastName());
            employee.setReportsTo(formBean.getReportsTo());
            employee.setExtension(formBean.getExtension());
            employee.setJobTitle(formBean.getJobTitle());
            employee.setProfileImageUrl(formBean.getProfilePicture());

            Office office = officeDAO.findOfficeById(formBean.getOfficeId());

            employee.setOffice(office);

            // when we save to the data base it will auto increment to give us a new id
            // the new ID is available in the return from the save method.
            // basically returns the same object .. after its been inserted into the database
            employee = employeeDAO.save(employee);

            // redirecting to the employee detail page
            // however often times this would redirect to the edit page (which we have not created)
            // after the redirect is actually a URL not a view name
            // in some ways this is overriding the behavior of the setViewName to use a URL rather than a JSP file location
            response.setViewName("redirect:/employees/employee/" + employee.getId());

            return response;
        }
    }
}
