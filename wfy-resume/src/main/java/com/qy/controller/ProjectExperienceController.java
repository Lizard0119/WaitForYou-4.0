package com.qy.controller;


import com.qy.pojo.resume.ProjectExperience;
import com.qy.pojo.resume.UserProjectExperience;

import com.qy.service.ProjectExperienceService;
import com.qy.service.UserProjectExperienceService;
import com.qy.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;
import java.util.List;
import java.util.Map;

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
    public Integer saveResumeProjectExperience(@RequestBody Map map, @PathVariable("userId")Integer userId) {

        int projectExperienceId = Integer.parseInt(map.get("projectExperienceId").toString());
        String projectExperienceName = map.get("projectExperienceName").toString();
        String projectExperienceRole = map.get("projectExperienceRole").toString();

        Date projectExperienceLastTime = DateUtil.strToUtilDate(map.get("projectExperienceLastTime").toString());

        Date projectExperienceBeforeTime = DateUtil.strToUtilDate(map.get("projectExperienceBeforeTime").toString());

        String projectExperienceDescribe = map.get("projectExperienceDescribe").toString();

        String projectExperiencePerformance = map.get("projectExperiencePerformance").toString();

        String projectExperienceConnect = map.get("projectExperienceConnect").toString();

        ProjectExperience projectExperience = new ProjectExperience
                (projectExperienceId,projectExperienceName,projectExperienceRole,projectExperienceLastTime,projectExperienceBeforeTime,projectExperienceDescribe,projectExperiencePerformance,projectExperienceConnect);



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
    public Integer updateResumeByProjectExperienceId (@RequestBody Map map) {
        int projectExperienceId = Integer.parseInt(map.get("projectExperienceId").toString());
        String projectExperienceName = map.get("projectExperienceName").toString();
        String projectExperienceRole = map.get("projectExperienceRole").toString();

        Date projectExperienceLastTime = DateUtil.strToUtilDate(map.get("projectExperienceLastTime").toString());

        Date projectExperienceBeforeTime = DateUtil.strToUtilDate(map.get("projectExperienceBeforeTime").toString());

        String projectExperienceDescribe = map.get("projectExperienceDescribe").toString();

        String projectExperiencePerformance = map.get("projectExperiencePerformance").toString();

        String projectExperienceConnect = map.get("projectExperienceConnect").toString();

        ProjectExperience projectExperience = new ProjectExperience
                (projectExperienceId,projectExperienceName,projectExperienceRole,projectExperienceLastTime,projectExperienceBeforeTime,projectExperienceDescribe,projectExperiencePerformance,projectExperienceConnect);



      //  System.out.println(projectExperience.getProjectExperienceLastTime().toString());
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
