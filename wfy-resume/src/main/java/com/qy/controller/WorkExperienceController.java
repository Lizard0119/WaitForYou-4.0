package com.qy.controller;


import com.alibaba.fastjson.JSONObject;
import com.qy.pojo.resume.UserWorkExperience;
import com.qy.pojo.resume.WorkExperience;
import com.qy.pojo.user.User;
import com.qy.service.UserWorkExperienceService;
import com.qy.service.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RequestMapping
@RestController("/workExperience")
public class WorkExperienceController {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    WorkExperienceService workExperienceService;

    @Autowired
    UserWorkExperienceService userWorkExperienceService;


    @RequestMapping("/findResumeByWorkExperienceUserId/{userId}")
    public List<WorkExperience> findResumeByWorkExperienceUserId(@PathVariable("userId") Integer userId){
        return workExperienceService.findResumeByWorkExperienceUserId(userId);
    }


    @RequestMapping("/saveWorkExperience")
    public String saveResumeSocial(@RequestBody WorkExperience workExperience, HttpServletRequest request){

        User user =findUserByToken(request);

        if (workExperienceService.saveWorkExperience(workExperience)>0){
            Integer socialId = workExperience.getWorkExperienceId();
            System.out.println(socialId);
            //预留关联表增加
            UserWorkExperience userWorkExperience = new UserWorkExperience();
            userWorkExperience.setWorkExperienceId(socialId);
            userWorkExperience.setUserId(user.getUserid());
           if (userWorkExperienceService.saveUserWorkExperience(userWorkExperience)>0){

          return "成功";}
       }
        return "失败";
    }


    @RequestMapping("/updateWorkExperience")
    public String updateWorkExperience(@RequestBody WorkExperience workExperience){
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


    public User findUserByToken(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String token = getToken(cookies);

        Object o = redisTemplate.opsForValue().get(token);
        Object o1 = JSONObject.toJSON(o);

        User tbUser = JSONObject.parseObject(o1.toString(), User.class);
        return tbUser;
    }

    public String getToken(Cookie [] cookies){
        if (cookies!=null){
            for (Cookie cook:cookies
            ) {
                if (cook.getName().equals("token")){
                    String token = cook.getValue();
                    return token;
                }
            }
            return null;
        }
        return null;
    }


}
