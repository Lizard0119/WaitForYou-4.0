package com.qy.controller;

import com.qy.pojo.sendresume.ResumeAndBoss;
import com.qy.pojo.sendresume.ResumeAndJob;
import com.qy.service.SendResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public String sendResume(@RequestParam ResumeAndBoss sendResume, @RequestParam ResumeAndJob resumeAndJob) {
//投递简历 需将简历-职位挂钩  简历-hr（boss）挂钩
        try {
            sendResumeService.insertWithResumeAndBoss(sendResume);
            sendResumeService.insertWithResumeAndJob(resumeAndJob);
            return "seccess";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }

    }
}
