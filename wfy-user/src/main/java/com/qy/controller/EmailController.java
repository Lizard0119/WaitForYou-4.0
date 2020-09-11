package com.qy.controller;

import com.qy.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class EmailController {

    @Resource
    EmailService emailService;

    @RequestMapping("/sendMail")
    public String sendMail(@RequestParam("mail") String mail){
        return emailService.sendMail(mail);
    }

}
