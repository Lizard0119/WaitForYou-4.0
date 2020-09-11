package com.qy.service;

import com.qy.pojo.sendresume.ResumeAndBoss;
import com.qy.pojo.sendresume.ResumeAndJob;

/**
 * @author Hz
 * 2020/9/10
 */
public interface SendResumeService {
   int insertWithResumeAndBoss(ResumeAndBoss sendResume); //往 简历-HR（BOSS）表 插入
   int insertWithResumeAndJob(ResumeAndJob resumeAndJob);//往 简历-职位表 插入
}
