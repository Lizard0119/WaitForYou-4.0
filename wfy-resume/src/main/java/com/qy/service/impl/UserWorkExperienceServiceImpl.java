package com.qy.service.impl;

import com.qy.dao.UserWorkExperienceDao;
import com.qy.pojo.resume.UserWorkExperience;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserWorkExperienceServiceImpl implements UserWorkExperienceDao {

    @Resource
    UserWorkExperienceDao userWorkExperienceDao;

    //通过用户id查寻工作经历关联表
    @Override
    public List<UserWorkExperienceDao> findResumeByUserWorkExperienceUserId(Integer userId) {
        return userWorkExperienceDao.findResumeByUserWorkExperienceUserId(userId);
    }

    //增加方法,添加用户id和工作经历id
    @Override
    public int saveUserWorkExperience(UserWorkExperience userWorkExperience) {
        return userWorkExperienceDao.saveUserWorkExperience(userWorkExperience);
    }

    //通过工作经历id单条删除方法
    @Override
    public int deleteUserWorkExperienceById(Integer WorkExperienceId) {
        return userWorkExperienceDao.deleteUserWorkExperienceById(WorkExperienceId);
    }

    //修改方法
    @Override
    public int updateWorkExperience(UserWorkExperience userWorkExperience) {
        return userWorkExperienceDao.updateWorkExperience(userWorkExperience);
    }
}
