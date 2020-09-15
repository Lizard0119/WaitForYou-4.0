package com.qy.controller;

import com.alibaba.fastjson.JSONObject;
import com.qy.pojo.resume.ProjectExperience;
import com.qy.pojo.resume.UserProjectExperience;
import com.qy.pojo.user.User;
import com.qy.service.ProjectExperienceService;
import com.qy.service.UserProjectExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/ProjectExperienceController")
public class ProjectExperienceController {



    @Autowired
    ProjectExperienceService projectExperienceService;
    @Autowired
    UserProjectExperienceService userProjectExperienceService;

    @RequestMapping("/findResumeByProjectExperienceId/{userId}")
    public List<ProjectExperience> findResumeByProjectExperienceId (@PathVariable("userId")Integer userId) {

        return projectExperienceService.findResumeByProjectExperienceId(userId);
    }

    @RequestMapping("/saveResumeProjectExperience/{userId}")
    public Integer saveResumeProjectExperience(@RequestBody ProjectExperience projectExperience, @PathVariable("userId")Integer userId) {


        if (projectExperienceService.saveResumeProjectExperience(projectExperience)>0){

            UserProjectExperience userProjectExperience = new UserProjectExperience();
            userProjectExperience.setProjectExperienceId(projectExperience.getProjectExperienceId());
            //用户的id 占时写死，后面接收前端传回来cook获取用户的id
            userProjectExperience.setUserId(userId);

            if (userProjectExperienceService.saveResumeUserProjectExperience(userProjectExperience)>0){
                return 1;
            }
        }
        return 0;
    }

    @RequestMapping("/updateResumeByProjectExperienceId")
    public Integer updateResumeByProjectExperienceId (@RequestBody ProjectExperience projectExperience) {
       if ( projectExperienceService.updateResumeByProjectExperienceId(projectExperience)>0){
           return 1;
       }
       return 0;
    }

    @RequestMapping("/deleteResumeByCertificateId/{certificateId}")
    public Integer deleteResumeByCertificateId(@PathVariable("certificateId")Integer projectExperienceId) {
        if ( projectExperienceService.deleteResumeByProjectExperienceId(projectExperienceId)>0){

            if ( userProjectExperienceService.deleteResumeByUserProjectExperienceId(projectExperienceId)>0){
                return 1;
            }
        }
        return 0;
    }

    @RequestMapping("/findByProjectExperienceId/{projectExperienceId}")
    public ProjectExperience findByProjectExperienceId(@PathVariable("projectExperienceId") Integer projectExperienceId) {

        return projectExperienceService.findByProjectExperienceId(projectExperienceId);

    }


}
