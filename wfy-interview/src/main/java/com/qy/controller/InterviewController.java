package com.qy.controller;

import com.qy.service.IInterviewService;
import com.qy.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
public class InterviewController {

    @Autowired
    private IInterviewService interviewService;



    @PostMapping("/saveInterview")
    public String saveInterview(@RequestBody Map map) {
        if (interviewService.saveInterview(map)) {
            return "success";
        } else {
            return "failed";
        }
    }

    @PostMapping("/removeInterview")
    public String removeInterview(@RequestBody Map map) {
        if (interviewService.removeInterview(map)) {
            return "success";
        } else {
            return "failed";
        }
    }

    @GetMapping("/formatDate/{datetime}")
    public String formatDate(@PathVariable("datetime") Date date) {
        return DateUtil.toStr(date);
    }
}
