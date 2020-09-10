package com.qy.service;

import com.qy.pojo.resume.UserResumeEducation;

import java.util.List;

public interface UserResumeEducationService {
    //通过用户id查寻工作经历关联表
    List<UserResumeEducation> findResumeByUserResumeEducationUserId(Integer userId);

    //增加方法
    int saveUserResumeEducation(UserResumeEducation userResumeEducation);

    //通过工作经历id单条删除方法
    int deleteUserResumeEducationById(Integer userResumeEducationId);
    //修改方法
    int updateUserResumeEducation(UserResumeEducation userResumeEducation);

}
