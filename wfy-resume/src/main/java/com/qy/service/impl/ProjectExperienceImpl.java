package com.qy.service.impl;

import com.qy.dao.ProjectExperienceDao;
import com.qy.pojo.resume.Certificate;
import com.qy.pojo.resume.ProjectExperience;
import com.qy.service.ProjectExperienceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectExperienceImpl implements ProjectExperienceService {

    @Resource
    ProjectExperienceDao projectExperienceDao;

    //查询所有的项目经验表
    @Override
    public List<Certificate> findResumeByProjectExperienceId(Integer userId) {
        return projectExperienceDao.findResumeByProjectExperienceId(userId);
    }

    //修改项目经验表
    @Override
    public Integer updateResumeByProjectExperienceId(ProjectExperience projectExperience) {
        return projectExperienceDao.updateResumeByProjectExperienceId(projectExperience);
    }

    //添加新的项目经验表
    @Override
    public Integer saveResumeProjectExperience(ProjectExperience projectExperience) {
        return projectExperienceDao.saveResumeProjectExperience(projectExperience);
    }

    //删除项目经验表
    @Override
    public Integer deleteResumeByProjectExperienceId(Integer certificateId) {
        return projectExperienceDao.deleteResumeByProjectExperienceId(certificateId);
    }

}
