package com.qy.service;

import com.qy.pojo.resume.ResumeEducation;

import java.util.List;

public interface ResumeEducationService {

    //通过用户id查询教育经历
    List<ResumeEducation> findResumeByResumeEducationUserId(Integer userId);

    //教育经历增加方法
    int saveResumeEducation(ResumeEducation resumeEducation);
    //教育经历删除方法
    int deleteResumeEducationById(Integer resumeEducationId);
    //通过教育经历id修改方法
    int updateResumeEducation(ResumeEducation resumeEducation);
}
