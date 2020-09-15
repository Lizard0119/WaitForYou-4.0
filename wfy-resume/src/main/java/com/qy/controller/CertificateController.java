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
    CertificateService certificateService;
    @Autowired
    UserCertificateService userCertificateService;

    @RequestMapping("/findResumeByCertificateId/{userId}")
    public List<Certificate> findResumeByCertificateId(@PathVariable("userId") Integer userId) {

        return certificateService.findResumeByCertificateId(userId);
    }


    @RequestMapping("/saveResumeCertificate/{userId}")
    public Integer saveResumeCertificate(@RequestBody Certificate certificate,@PathVariable("userId") Integer userId) {


        if (certificateService.saveResumeCertificate(certificate)>0){

            certificate.getCertificateId();

            UserCertificate userCertificate = new UserCertificate();
            userCertificate.setCertificateId(certificate.getCertificateId());
            //用户的id 占时写死，后面接收前端传回来cook获取用户的id

            userCertificate.setUserId(userId);

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


    @RequestMapping("/findByCertificateId/{certificateId}")
    public Certificate findByCertificateId(@PathVariable("certificateId") Integer certificateId) {

        return certificateService.findByCertificateId(certificateId);

    }

}
