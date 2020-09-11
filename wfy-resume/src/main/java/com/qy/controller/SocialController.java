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
    RedisTemplate redisTemplate;

    @Autowired
    UserSocialService userSocialService;

    private UserSocial userSocial;

    @RequestMapping("/findSocial/{userId}")
    public List<Social> findResumeBySocialUserId(@PathVariable("userId") Integer userId){
        return socialService.findResumeBySocialUserId(userId);
    }


    @RequestMapping("/saveResumeSocial")
    public String saveResumeSocial(@RequestBody Social social, HttpServletRequest request){

        User user =findUserByToken(request);
       if (socialService.saveResumeSocial(social)>0){
           Integer socialId = social.getSocialId();
           System.out.println(socialId);
            //预留关联表增加
            userSocial.setSocialId(socialId);
            userSocial.setUserId(user.getUserid());
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
