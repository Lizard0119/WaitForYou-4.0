package com.qy.service;

import com.qy.pojo.resume.Resume;
import com.qy.pojo.sendresume.UserAndJob;

import java.util.List;

/**
 * @author Hz
 * 2020/9/11
 */
public interface CheckResumeService {
    //查 招聘信息 下 的所有用户
    List<UserAndJob> selectResumeByJob(int jobid);
    //HR 删除简历
    int deleteResumeByUserId(int userid);
    //根据用户id查简历
    Resume selectResumeByuserId(int userid);
    //查 该HR下 所有 用户
    List<UserAndJob> selectResumeByBoss(Integer bossid);
}
