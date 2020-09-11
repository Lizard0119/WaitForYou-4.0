package com.qy.controller;

import com.alibaba.fastjson.JSONObject;
import com.qy.pojo.resume.Certificate;
import com.qy.pojo.resume.UserCertificate;
import com.qy.pojo.user.User;
import com.qy.service.CertificateService;
import com.qy.service.UserCertificateService;
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
@RequestMapping("/CertificateController")
public class CertificateController {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    CertificateService certificateService;
    @Autowired
    UserCertificateService userCertificateService;

    @RequestMapping("/findResumeByCertificateId/{userId}")
    public List<Certificate> findResumeByCertificateId(@PathVariable("userId") Integer userId) {

        return certificateService.findResumeByCertificateId(userId);
    }


    @RequestMapping("/saveResumeCertificate")
    public Integer saveResumeCertificate(@RequestBody Certificate certificate,  HttpServletRequest request) {

        User user =findUserByToken(request);
        if (certificateService.saveResumeCertificate(certificate)>0){

            certificate.getCertificateId();

            UserCertificate userCertificate = new UserCertificate();
            userCertificate.setCertificateId(certificate.getCertificateId());
            //用户的id 占时写死，后面接收前端传回来cook获取用户的id

            userCertificate.setUserId(user.getUserid());

            if(userCertificateService.saveResumeUserCertificate(userCertificate)>0){
                return 1;
            }
        }
        return 0;
    }

    @RequestMapping("/updateResumeByCertificateId")
    public Integer updateResumeByCertificateId(@RequestBody Certificate certificate) {

        if ( certificateService.updateResumeByCertificateId(certificate)>0){
            return 1;
        }
        return 0;
    }

    @RequestMapping("/deleteResumeByCertificateId/{certificateId}")
    public Integer deleteResumeByCertificateId(@PathVariable("certificateId")Integer certificateId) {
        if ( certificateService.deleteResumeByCertificateId(certificateId)>0){

            if ( userCertificateService.deleteResumeByUserCertificateId(certificateId)>0){
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
