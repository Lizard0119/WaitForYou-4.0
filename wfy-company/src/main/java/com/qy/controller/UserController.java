package com.qy.controller;

import com.qy.pojo.user.User;
import com.qy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping("/changeUser/{id}")
    public String changeUser(@PathVariable("id") int id) {
        User user = service.getUser(id);
        return service.changeUser(user);
    }

    @RequestMapping("/getIdentifyId/{id}")
    public User getIdentifyId(@PathVariable("id") int id) {
        return service.getUserIdentifyId(id);
    }
}
