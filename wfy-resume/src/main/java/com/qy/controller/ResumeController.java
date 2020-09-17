package com.qy.controller;


import com.qy.pojo.resume.Certificate;
import com.qy.pojo.resume.Resume;
import com.qy.service.*;
import com.qy.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/resume")
public class ResumeController {


    @Autowired
    CertificateService certificateService;
    @Autowired
    IntentionService intentionService;
    @Autowired
    ResumeEducationService resumeEducationService;
    @Autowired
    ProjectExperienceService projectExperienceService;
    @Autowired
    SocialService socialService;
    @Autowired
    WorkExperienceService workExperienceService;
    @RequestMapping("/resume/{userId}")
    public Resume sff(@PathVariable("userId") Integer userId){

        Resume resume = new Resume();
        List<Certificate> resumeByCertificateId = certificateService.findResumeByCertificateId(userId);
        resume.setCertificate(resumeByCertificateId);
        resume.setIntention(intentionService.findResumeByIntentionId(userId));
        resume.setProjectExperience(projectExperienceService.findResumeByProjectExperienceId(userId));

        resume.setResumeEducation(resumeEducationService.findResumeByResumeEducationUserId(userId));
        resume.setSocial(socialService.findResumeBySocialUserId(userId));
        resume.setWorkExperience(workExperienceService.findResumeByWorkExperienceUserId(userId));
        System.out.println(1);
        System.out.println(resume.toString());
        return resume;
    }

    @GetMapping("/formatDate/{datetime}")
    public String formatDate(@PathVariable("datetime") Date date) {
        return DateUtil.toStr(date);
    }
}
