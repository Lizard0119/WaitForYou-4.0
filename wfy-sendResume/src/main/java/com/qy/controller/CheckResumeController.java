package com.qy.controller;

import com.qy.pojo.resume.Resume;
import com.qy.pojo.sendresume.UserAndJob;
import com.qy.service.CheckResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Hz
 * 2020/9/11
 */
@RestController
public class CheckResumeController {
    @Autowired
    CheckResumeService checkResumeService;
    // HR 根据招聘信息 查谁投了简历
    @GetMapping("/checkbyjobid/{jobid}")
    public List<UserAndJob> selectResumeByJob(@PathVariable("jobid") Integer jobid){
       return checkResumeService.selectResumeByJob(jobid);
    }
    //HR根据用户id查看简历
    @GetMapping("checkbyuserid/{userid}")
    public Resume selectByJob(@PathVariable("userid") int userid){
        return checkResumeService.selectResumeByuserId(userid);
    }

    //删除简历
    @RequestMapping("/deletebyuserid/{userid}")
    public String deleteByResumeId(@PathVariable("userid") int id){
        try {
            checkResumeService.deleteResumeByUserId(id);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

}
