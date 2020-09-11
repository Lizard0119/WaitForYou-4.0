package com.qy.controller;

import com.alibaba.fastjson.JSONObject;
import com.qy.pojo.resume.Intention;
import com.qy.pojo.resume.UserIntention;
import com.qy.pojo.user.User;
import com.qy.service.IntentionService;
import com.qy.service.UserIntentionService;
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
@RequestMapping("/IntentionController")
public class IntentionController {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    IntentionService intentionService;
    @Autowired
    UserIntentionService userIntentionService;

    @RequestMapping("/findResumeByIntentionId/{userId}")
    public List<Intention> findResumeByIntentionId(@PathVariable("userId")Integer userId) {

        return intentionService.findResumeByIntentionId(userId);
    }

    @RequestMapping("/saveResumeIntention")
    public Integer saveResumeIntention(@RequestBody Intention intention,  HttpServletRequest request) {

        User user = findUserByToken(request);
        if (intentionService.saveResumeIntention(intention) > 0) {
            intention.getIntentionId();
            UserIntention userIntention = new UserIntention();
            userIntention.setIntentionId(intention.getIntentionId());
            //用户的id 占时写死，后面接收前端传回来cook获取用户的id
            userIntention.setUserId(user.getUserid());

            if (userIntentionService.saveResumeUserIntention(userIntention) > 0) {
                return 1;
            }
        }
        return 0;
    }


    @RequestMapping("/updateResumeByIntentionId")
    public Integer updateResumeByIntentionId(@RequestBody Intention intention) {

        if ( intentionService.updateResumeByIntentionId(intention)>0){
            return 1;
        }
        return 0;
    }

    @RequestMapping("/deleteResumeByCertificateId/{certificateId}")
    public Integer deleteResumeByCertificateId(@PathVariable("certificateId")Integer intentionId) {
        if ( intentionService.deleteResumeByIntentionId(intentionId)>0){

            if ( userIntentionService.deleteResumeByUserIntentionId(intentionId)>0){
                return 1;
            }
        }
        return 0;
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
