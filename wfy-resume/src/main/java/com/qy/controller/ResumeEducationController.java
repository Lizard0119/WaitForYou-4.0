package com.qy.controller;



import com.alibaba.fastjson.JSONObject;
import com.qy.pojo.resume.ResumeEducation;
import com.qy.pojo.resume.Social;
import com.qy.pojo.resume.UserResumeEducation;
import com.qy.pojo.user.User;
import com.qy.service.ResumeEducationService;
import com.qy.service.UserResumeEducationService;
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
@RequestMapping("/resumeEducation")
public class ResumeEducationController {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    ResumeEducationService resumeEducationService;

    @Autowired
    UserResumeEducationService userResumeEducationService;

    private UserResumeEducation userResumeEducation;


    @RequestMapping("/findSocialResumeEducation/{userId}")
    public List<ResumeEducation> findResumeByResumeEducationUserId(@PathVariable("userId") Integer userId){
        return resumeEducationService.findResumeByResumeEducationUserId(userId);
    }


    @RequestMapping("/saveResumeSocial")
    public String saveResumeEducation(@RequestBody ResumeEducation resumeEducation, HttpServletRequest request){

        User user =findUserByToken(request);
        if (resumeEducationService.saveResumeEducation(resumeEducation)>0){
            Integer socialId = resumeEducation.getResumeEducationId();
            System.out.println(socialId);
            //预留关联表增加
            userResumeEducation.setResumeEducationId(socialId);
            userResumeEducation.setUserId(user.getUserid());
           if (userResumeEducationService.saveUserResumeEducation(userResumeEducation)>0){

          return "成功";}
        }
        return "失败";
    }


    @RequestMapping("/updateResumeEducation")
    public String updateResumeEducation(@RequestBody ResumeEducation resumeEducation){
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
