package com.qy.service.impl;

import com.qy.dao.ResumeEducationDao;
import com.qy.pojo.resume.ResumeEducation;
import com.qy.service.ResumeEducationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResumeEducationServiceImpl implements ResumeEducationService {

    @Resource
    ResumeEducationDao resumeEducationDao;

    //通过用户id查询教育经历
    @Override
    public List<ResumeEducation> findResumeByResumeEducationUserId(Integer userId) {

        return resumeEducationDao.findResumeByResumeEducationUserId(userId);
    }

    //教育经历增加方法
    @Override
    public int saveResumeEducation(ResumeEducation resumeEducation) {
        return resumeEducationDao.saveResumeEducation(resumeEducation);
    }

    //教育经历删除方法
    @Override
    public int deleteResumeEducationById(Integer resumeEducationId) {
        return resumeEducationDao.deleteResumeEducationById(resumeEducationId);
    }

    //通过教育经历id修改方法
    @Override
    public int updateResumeEducation(ResumeEducation resumeEducation) {
        return resumeEducationDao.updateResumeEducation(resumeEducation);
    }
}
