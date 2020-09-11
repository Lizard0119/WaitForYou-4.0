package com.qy.dao;

import com.qy.pojo.sendresume.ResumeAndBoss;
import com.qy.pojo.sendresume.ResumeAndJob;

/**
 * @author Hz
 * 2020/9/11
 */
public interface SendResumeDao {
    int insertWithResumeAndBoss(ResumeAndBoss sendResume);      //往 简历-HR（BOSS）表 插入
    int insertWithResumeAndJob(ResumeAndJob resumeAndJob);      //往 简历-职位表 插入
}
