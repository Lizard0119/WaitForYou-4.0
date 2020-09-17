package com.qy.controller;

import com.alibaba.fastjson.JSONObject;
import com.qy.pojo.resume.Social;
import com.qy.pojo.resume.UserSocial;
import com.qy.pojo.user.User;
import com.qy.service.SocialService;
import com.qy.service.UserSocialService;
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
@RequestMapping("/social")
public class SocialController {

    @Autowired
    SocialService socialService;

    @Autowired
    UserSocialService userSocialService;

   // private UserSocial userSocial;

    @RequestMapping("/findSocial/{userId}")
    public List<Social> findResumeBySocialUserId(@PathVariable("userId") Integer userId){
        return socialService.findResumeBySocialUserId(userId);
    }


    @RequestMapping("/saveResumeSocial/{userId}")
    public String saveResumeSocial(@RequestBody Social social, @PathVariable("userId") Integer userId){


       if (socialService.saveResumeSocial(social)>0){
           Integer socialId = social.getSocialId();
           System.out.println(socialId);
            //预留关联表增加
           UserSocial userSocial = new UserSocial();
           userSocial.setSocialId(socialId);
           userSocial.setUserId(userId);
           if (userSocialService.saveUserUserSocial(userSocial)>0){

          return "成功";}
        }
       return "失败";
    }


    @RequestMapping("/updateSocial")
    public String updateSocial(@RequestBody Social social){
       if ( socialService.updateSocial(social)>0){
           return "成功";
       }
        return "失败";
    }

    @RequestMapping("/deleteSocialById/{socialId}")
    public String sd(@PathVariable("socialId") Integer socialId){
        if ( socialService.deleteSocialById(socialId)>0){

            if (userSocialService.deleteUserUserSocialById(socialId)>0){
                return "成功";
            }

        }
        return "失败";
    }

    @RequestMapping("/findByResumeEducationUserId/{socialId}")
    public Social findBySocialUserId(@PathVariable("socialId") Integer socialId) {

        return socialService.findBySocialUserId(socialId);

    }

}
