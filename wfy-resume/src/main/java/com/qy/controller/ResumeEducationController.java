package com.qy.controller;



import com.alibaba.fastjson.JSONObject;
import com.qy.pojo.resume.ResumeEducation;
import com.qy.pojo.resume.Social;
import com.qy.pojo.resume.UserResumeEducation;
import com.qy.pojo.user.User;
import com.qy.service.ResumeEducationService;
import com.qy.service.UserResumeEducationService;
import com.qy.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/resumeEducation")
public class ResumeEducationController {



    @Autowired
    ResumeEducationService resumeEducationService;

    @Autowired
    UserResumeEducationService userResumeEducationService;

    private UserResumeEducation userResumeEducation;


    @RequestMapping("/findSocialResumeEducation/{userId}")
    public List<ResumeEducation> findResumeByResumeEducationUserId(@PathVariable("userId") Integer userId){
        return resumeEducationService.findResumeByResumeEducationUserId(userId);
    }


    @RequestMapping("/saveResumeSocial/{userId}")
    public String saveResumeEducation(@RequestBody Map map, @PathVariable("userId") Integer userId){

        int resumeEducationId = Integer.parseInt(map.get("resumeEducationId").toString());

        String resumeEducationSchool = map.get("resumeEducationSchool").toString();

        String resumeEducationBackground = map.get("resumeEducationBackground").toString();

        String resumeEducationMajor = map.get("resumeEducationMajor").toString();

        Date resumeEducationBeforeTime = DateUtil.strToUtilDate(map.get("resumeEducationBeforeTime").toString());

        Date resumeEducationLastTime = DateUtil.strToUtilDate(map.get("resumeEducationLastTime").toString());

        String resumeEducationExperience = map.get("resumeEducationExperience").toString();

        ResumeEducation resumeEducation = new ResumeEducation(resumeEducationId,resumeEducationSchool,resumeEducationBackground,resumeEducationMajor,resumeEducationLastTime,resumeEducationBeforeTime,resumeEducationExperience);



        if (resumeEducationService.saveResumeEducation(resumeEducation)>0){
            Integer socialId = resumeEducation.getResumeEducationId();

            //预留关联表增加
            userResumeEducation.setResumeEducationId(socialId);
            userResumeEducation.setUserId(userId);
           if (userResumeEducationService.saveUserResumeEducation(userResumeEducation)>0){

          return "成功";}
        }
        return "失败";
    }


    @RequestMapping("/updateResumeEducation")
    public String updateResumeEducation(@RequestBody Map map){

        int resumeEducationId = Integer.parseInt(map.get("resumeEducationId").toString());

        String resumeEducationSchool = map.get("resumeEducationSchool").toString();

        String resumeEducationBackground = map.get("resumeEducationBackground").toString();

        String resumeEducationMajor = map.get("resumeEducationMajor").toString();

        Date resumeEducationBeforeTime = DateUtil.strToUtilDate(map.get("resumeEducationBeforeTime").toString());

        Date resumeEducationLastTime = DateUtil.strToUtilDate(map.get("resumeEducationLastTime").toString());

        String resumeEducationExperience = map.get("resumeEducationExperience").toString();

        ResumeEducation resumeEducation = new ResumeEducation(resumeEducationId,resumeEducationSchool,resumeEducationBackground,resumeEducationMajor,resumeEducationLastTime,resumeEducationBeforeTime,resumeEducationExperience);


        if ( resumeEducationService.updateResumeEducation(resumeEducation)>0){
            return "成功";
        }
        return "失败";
    }

    @RequestMapping("/deleteSocialById/{resumeEducationId}")
    public String sd(@PathVariable("resumeEducationId") Integer resumeEducationId){
        if ( resumeEducationService.deleteResumeEducationById(resumeEducationId)>0){

            if (userResumeEducationService.deleteUserResumeEducationById(resumeEducationId)>0){
                return "成功";
            }

        }
        return "失败";
    }


    @RequestMapping("/findByResumeEducationUserId/{resumeEducationId}")
    public ResumeEducation findByResumeEducationUserId(@PathVariable("resumeEducationId") Integer resumeEducationId) {

        return resumeEducationService.findByResumeEducationUserId(resumeEducationId);

    }


}
