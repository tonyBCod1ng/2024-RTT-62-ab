package com.example.springBoot.service;

import com.example.springBoot.database.dao.UserDAO;
import com.example.springBoot.database.entity.User;
import com.example.springBoot.form.CreateAccountFormBean;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Slf4j
@Component
public class UserService {

    @Autowired
    private UserDAO userDao;


    public User createUser(CreateAccountFormBean form) {
        // there were no errors so we can create the new user in the database
        User user = new User();

        user.setEmail(form.getEmail());

        // we are getting in a plain text password because the user entered it into the form
        user.setPassword(form.getPassword());
        user.setCreateDate(new Date());

        // save the user to the database
        userDao.save(user);

        return user;
    }

}