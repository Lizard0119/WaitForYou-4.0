package com.qy.service;

/**
 * @author Hz
 * 2020/9/10
 */
public interface SendResumeService {
   //往 简历-HR（BOSS）表 插入
//   int insertWithResumeAndBoss(int resid,int bossid);
   //往 简历-招聘信息(job)表 插入
//   int insertWithResumeAndJob( int resid, int jobid);
   //通过job表 找到 HR id
//   Boss selectByJobId( int jobid);
   //用户与招聘信息表关联
   int insertWithUserAndJob(int userid,int jobid);
}
