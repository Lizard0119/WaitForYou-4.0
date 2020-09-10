package com.qy.service;

import com.qy.pojo.resume.Certificate;
import com.qy.pojo.resume.ProjectExperience;

import java.util.List;


public interface ProjectExperienceService {


    //查询所有的项目经验表
    List<Certificate> findResumeByProjectExperienceId(Integer userId);
    //修改项目经验表
    Integer updateResumeByProjectExperienceId(ProjectExperience projectExperience);
    //添加新的项目经验表
    Integer saveResumeProjectExperience(ProjectExperience projectExperience);
    //删除项目经验表
    Integer deleteResumeByProjectExperienceId(Integer certificateId);
}
