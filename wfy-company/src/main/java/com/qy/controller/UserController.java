package com.qy.controller;

import com.qy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping("/changeUser")
    public String changeUser(String id) {
        return service.changeUser(id);
    }


}
