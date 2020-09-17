package com.qy.controller;

import com.qy.pojo.user.User;
import com.qy.pojo.user.UserReq;
import com.qy.service.IUserService;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    public Map login(@RequestBody User user){
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

    /**
     * 通过用户id查询单个用户
     * @param userid
     * @return
     */
    @GetMapping("/getUserById/{userid}")
    public User getUserById(@PathVariable int userid){
        return userService.getUserById(userid);
    }

    /**
     * 修改个人信息
     * @param user
     * @return
     */
    @PostMapping("/update")
    public String update(@RequestBody User user){
        return userService.updateUser(user);
    }

}
