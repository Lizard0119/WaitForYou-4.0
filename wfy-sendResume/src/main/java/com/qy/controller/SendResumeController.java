package com.qy.controller;

import com.qy.service.SendResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Hz
 * 2020/9/10
 */
@RestController
@RequestMapping("/sendresume")
public class SendResumeController {
    @Autowired
    SendResumeService sendResumeService;
    @RequestMapping("/send")
    public String sendResume(Map map){
return sendResumeService.sendResume();
    }
}
