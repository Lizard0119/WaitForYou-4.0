package com.qy.service;

import com.qy.pojo.resume.UserProjectExperience;

import java.util.List;


public interface UserProjectExperienceService {


    //查询所有的项目经验和用户的联合表
    List<UserProjectExperience> findResumeByUserProjectExperienceId(Integer userId);
    //修改项目经验和用户的联合表
    Integer updateResumeByUserProjectExperienceId(UserProjectExperience userProjectExperience);
    //添加新的项目经验和用户的联合表
    Integer saveResumeUserProjectExperience(UserProjectExperience userProjectExperience);
    //删除项目经验和用户的联合表
    Integer deleteResumeByUserProjectExperienceId(Integer projectExperienceId);
}
