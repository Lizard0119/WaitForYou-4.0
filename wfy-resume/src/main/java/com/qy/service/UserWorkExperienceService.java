package com.qy.service;

import com.qy.dao.UserWorkExperienceDao;
import com.qy.pojo.resume.UserWorkExperience;

import java.util.List;

public interface UserWorkExperienceService {

    //通过用户id查寻工作经历关联表
    List<UserWorkExperienceDao> findResumeByUserWorkExperienceUserId(Integer userId);

    //增加方法,添加用户id和工作经历id
    int saveUserWorkExperience(UserWorkExperience userWorkExperience);

    //通过工作经历id单条删除方法
    int deleteUserWorkExperienceById(Integer WorkExperienceId);
    //修改方法
    int updateWorkExperience(UserWorkExperience userWorkExperience);
}
