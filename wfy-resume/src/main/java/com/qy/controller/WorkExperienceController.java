package com.qy.controller;


import com.alibaba.fastjson.JSONObject;
import com.qy.pojo.resume.UserWorkExperience;
import com.qy.pojo.resume.WorkExperience;
import com.qy.pojo.user.User;
import com.qy.service.UserWorkExperienceService;
import com.qy.service.WorkExperienceService;
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


@RequestMapping("/workExperience")
@RestController
public class WorkExperienceController {


    @Autowired
    WorkExperienceService workExperienceService;

    @Autowired
    UserWorkExperienceService userWorkExperienceService;


    @RequestMapping("/findResumeByWorkExperienceUserId/{userId}")
    public List<WorkExperience> findResumeByWorkExperienceUserId(@PathVariable("userId") Integer userId){
        return workExperienceService.findResumeByWorkExperienceUserId(userId);
    }


    @RequestMapping("/saveWorkExperience/{userId}")
    public String saveResumeSocial(@RequestBody Map map, @PathVariable("userId") Integer userId){


        int workExperienceId = Integer.parseInt(map.get("workExperienceId").toString());


        String workExperienceCompany = map.get("workExperienceCompany").toString();

        String workExperienceIndustry = map.get("workExperienceIndustry").toString();

        Date workExperienceWorkingTimeBegin = DateUtil.strToUtilDate(map.get("workExperienceWorkingTimeBegin").toString());

        Date workExperienceWorkingTimeEnd = DateUtil.strToUtilDate(map.get("workExperienceWorkingTimeEnd").toString());

        String workExperienceType = map.get("workExperienceType").toString();


        String workExperienceDepartment = map.get("workExperienceDepartment").toString();

        String workExperienceContent = map.get("workExperienceContent").toString();
        String workExperiencePerformance = map.get("workExperiencePerformance").toString();

        WorkExperience workExperience = new WorkExperience(workExperienceId,workExperienceCompany,workExperienceIndustry,workExperienceWorkingTimeBegin,workExperienceWorkingTimeEnd,workExperienceType,workExperienceDepartment,workExperienceContent,workExperiencePerformance);


        if (workExperienceService.saveWorkExperience(workExperience)>0){
            Integer socialId = workExperience.getWorkExperienceId();

            //预留关联表增加
            UserWorkExperience userWorkExperience = new UserWorkExperience();
            userWorkExperience.setWorkExperienceId(socialId);
            userWorkExperience.setUserId(userId);
           if (userWorkExperienceService.saveUserWorkExperience(userWorkExperience)>0){

          return "成功";}
       }
        return "失败";
    }


    @RequestMapping("/updateWorkExperience")
    public String updateWorkExperience(@RequestBody Map map){

        int workExperienceId = Integer.parseInt(map.get("workExperienceId").toString());


        String workExperienceCompany = map.get("workExperienceCompany").toString();

        String workExperienceIndustry = map.get("workExperienceIndustry").toString();

        Date workExperienceWorkingTimeBegin = DateUtil.strToUtilDate(map.get("workExperienceWorkingTimeBegin").toString());

        Date workExperienceWorkingTimeEnd = DateUtil.strToUtilDate(map.get("workExperienceWorkingTimeEnd").toString());

        String workExperienceType = map.get("workExperienceType").toString();


        String workExperienceDepartment = map.get("workExperienceDepartment").toString();

        String workExperienceContent = map.get("workExperienceContent").toString();
        String workExperiencePerformance = map.get("workExperiencePerformance").toString();

        WorkExperience workExperience = new WorkExperience(workExperienceId,workExperienceCompany,workExperienceIndustry,workExperienceWorkingTimeBegin,workExperienceWorkingTimeEnd,workExperienceType,workExperienceDepartment,workExperienceContent,workExperiencePerformance);
        if ( workExperienceService.updateWorkExperience(workExperience)>0){
            return "成功";
        }
        return "失败";
    }

    @RequestMapping("/deleteWorkExperienceById/{workExperienceId}")
    public String sd(@PathVariable("workExperienceId") Integer  workExperienceId){
        if ( workExperienceService.deleteWorkExperienceById(workExperienceId)>0){

            if (userWorkExperienceService.deleteUserWorkExperienceById(workExperienceId)>0){
                return "成功";
            }

        }
        return "失败";
    }

    @RequestMapping("/findByWorkExperienceUserId/{workExperienceId}")
    public WorkExperience findByWorkExperienceUserId(@PathVariable("workExperienceId") Integer workExperienceId) {

        return workExperienceService.findByWorkExperienceUserId(workExperienceId);

    }



}
