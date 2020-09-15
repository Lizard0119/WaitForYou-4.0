package com.qy.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Hz
 * 2020/9/11
 */
@Mapper
public interface SendResumeDao {
    //往 简历-HR（BOSS）表 插入
//    int insertWithResumeAndBoss(@Param("resumeId") int resid, @Param("bossId") int bossid);
    //往 简历-招聘信息(job)表 插入
//    int insertWithResumeAndJob(@Param("resumeId") int resid,@Param("jobId") int jobid);
    //通过job表 找到 HR id
//    Boss selectByJobId(@Param("jobId") int jobid);

    //用户与招聘信息表关联
//    int insertWithUserAndJob(@Param("userid")int userid,@Param("jobId") int jobid);
    int insertWithUserAndJob(@Param("jobid")int jobid, @Param("userid")int userid);
}
