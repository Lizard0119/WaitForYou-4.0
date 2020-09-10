package com.qy.service;

import com.qy.pojo.resume.WorkExperience;

import java.util.List;

public interface WorkExperienceService {

    //通过用户id查询工作经历
    List<WorkExperience> findResumeByWorkExperienceUserId(Integer userId);

    //工作经历增加方法
    int saveWorkExperience(WorkExperience workExperience);
    //工作经历删除方法
    int deleteWorkExperienceById(Integer workExperienceId);
    //工作经历删除方法
    int updateWorkExperience(WorkExperience workExperience);
}
