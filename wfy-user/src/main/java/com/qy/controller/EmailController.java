package com.qy.controller;

import com.qy.service.EmailService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class EmailController {

    @Resource
    EmailService emailService;

    @RequestMapping("/sendMail")
    public String sendMail(@RequestBody Map map){
        Object email = map.get("email");
        return emailService.sendMail(email.toString());
    }

}
