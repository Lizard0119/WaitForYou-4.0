package com.qy.service.impl;

import com.qy.dao.UserResumeEducationDao;
import com.qy.pojo.resume.UserResumeEducation;
import com.qy.service.UserResumeEducationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserResumeEducationServiceImpl implements UserResumeEducationService {

    @Resource
    UserResumeEducationDao userResumeEducationDao;

    //通过用户id查寻工作经历关联表
    @Override
    public List<UserResumeEducation> findResumeByUserResumeEducationUserId(Integer userId) {
        return userResumeEducationDao.findResumeByUserResumeEducationUserId(userId);
    }

    //增加方法
    @Override
    public int saveUserResumeEducation(UserResumeEducation userResumeEducation) {
        return userResumeEducationDao.saveUserResumeEducation(userResumeEducation);
    }

    //通过工作经历id单条删除方法
    @Override
    public int deleteUserResumeEducationById(Integer userResumeEducationId) {
        return userResumeEducationDao.deleteUserResumeEducationById(userResumeEducationId);
    }

    //修改方法
    @Override
    public int updateUserResumeEducation(UserResumeEducation userResumeEducation) {
        return userResumeEducationDao.updateUserResumeEducation(userResumeEducation);
    }
}
