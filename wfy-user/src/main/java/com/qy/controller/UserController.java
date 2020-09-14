package com.qy.controller;

import com.qy.pojo.user.User;
import com.qy.pojo.user.UserReq;
import com.qy.service.IUserService;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    IUserService userService;

    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public String login(@RequestBody User user){
        return userService.login(user);
    }

    /**
     * 注册
     * @param
     * @return
     */
    @PostMapping("/register")
    public String register(@RequestBody UserReq userReq){
        return userService.register(userReq);
    }

}
