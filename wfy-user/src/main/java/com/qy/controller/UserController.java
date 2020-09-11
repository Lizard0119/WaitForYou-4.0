package com.qy.controller;

import com.qy.pojo.user.User;
import com.qy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    IUserService userService;

    @RequestMapping("/login")
    public String login(@RequestBody User user){
        return userService.login(user);
    }

//    @RequestMapping("/register")
//    public String register(@RequestBody User user){
//        return userService.Register(user);
//    }

}
