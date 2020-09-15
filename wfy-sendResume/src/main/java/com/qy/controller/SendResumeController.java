package com.qy.controller;

import com.qy.service.SendResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/send")
    public String sendResume(@RequestBody Map map) {
//投递简历 需将简历-招聘信息挂钩 通过招聘信息获取到HR id 简历-hr（boss）挂钩

        Integer userid = (Integer) map.get("userid");
        Integer jobid = (Integer) map.get("jobid");
        int i = sendResumeService.insertWithUserAndJob(userid,jobid);
        if (i > 0) {
            return "success";
        }
        return "fail";
    }
}
