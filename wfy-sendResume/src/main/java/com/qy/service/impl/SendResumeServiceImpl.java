package com.qy.service.impl;

import com.qy.dao.SendResumeDao;
import com.qy.pojo.sendresume.ResumeAndBoss;
import com.qy.pojo.sendresume.ResumeAndJob;
import com.qy.service.SendResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Hz
 * 2020/9/10
 */
@Service
public class SendResumeServiceImpl implements SendResumeService {

    @Autowired
   SendResumeDao sendResumeDao;
    @Override
    //往 简历-HR（BOSS）表 插入
    public int insertWithResumeAndBoss(ResumeAndBoss resumeAndBoss) {
        return sendResumeDao.insertWithResumeAndBoss(resumeAndBoss);
    }

    @Override
    //往 简历-职位表 插入
    public int insertWithResumeAndJob(ResumeAndJob resumeAndJob) {
        return sendResumeDao.insertWithResumeAndJob(resumeAndJob);
    }
}
