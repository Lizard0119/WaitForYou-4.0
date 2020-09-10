package com.qy.service.impl;

import com.qy.dao.UserProjectExperienceDao;
import com.qy.pojo.resume.UserProjectExperience;
import com.qy.service.UserProjectExperienceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserProjectExperienceServiceImpl implements UserProjectExperienceService {

    @Resource
    UserProjectExperienceDao userProjectExperienceDao;

    //查询所有的项目经验和用户的联合表
    @Override
    public List<UserProjectExperience> findResumeByUserProjectExperienceId(Integer userId) {
        return userProjectExperienceDao.findResumeByUserProjectExperienceId(userId);
    }

    //修改项目经验和用户的联合表
    @Override
    public Integer updateResumeByUserProjectExperienceId(UserProjectExperience userProjectExperience) {
        return userProjectExperienceDao.updateResumeByUserProjectExperienceId(userProjectExperience);
    }

    //添加新的项目经验和用户的联合表
    @Override
    public Integer saveResumeUserProjectExperience(UserProjectExperience userProjectExperience) {
        return userProjectExperienceDao.saveResumeUserProjectExperience(userProjectExperience);
    }

    //删除项目经验和用户的联合表
    @Override
    public Integer deleteResumeByUserProjectExperienceId(Integer projectExperienceId) {
        return userProjectExperienceDao.deleteResumeByUserProjectExperienceId(projectExperienceId);
    }

}
