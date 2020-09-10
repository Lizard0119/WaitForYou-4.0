package com.qy.service.impl;

import com.qy.dao.WorkExperienceDao;
import com.qy.pojo.resume.WorkExperience;
import com.qy.service.WorkExperienceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WorkExperienceServiceImpl implements WorkExperienceService {

    @Resource
    WorkExperienceDao workExperienceDao;

    //通过用户id查询工作经历
    @Override
    public List<WorkExperience> findResumeByWorkExperienceUserId(Integer userId) {
        return workExperienceDao.findResumeByWorkExperienceUserId(userId);
    }

    //工作经历增加方法
    @Override
    public int saveWorkExperience(WorkExperience workExperience) {
        return workExperienceDao.saveWorkExperience(workExperience);
    }

    //工作经历删除方法
    @Override
    public int deleteWorkExperienceById(Integer workExperienceId) {
        return workExperienceDao.deleteWorkExperienceById(workExperienceId);
    }

    //工作经历删除方法
    @Override
    public int updateWorkExperience(WorkExperience workExperience) {
        return workExperienceDao.updateWorkExperience(workExperience);
    }
}
