package com.qy.service.impl;

import com.qy.client.SelectResumeClient;
import com.qy.dao.CheckResumeDao;
import com.qy.pojo.resume.Resume;
import com.qy.pojo.sendresume.UserAndJob;
import com.qy.service.CheckResumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Hz
 * 2020/9/15
 */
@Service
public class CheckResumeServiceImpl implements CheckResumeService {
    @Resource
    private SelectResumeClient selectResumeClient;
    @Resource
    private CheckResumeDao checkResumeDao;
    //查 招聘信息 下 的所有用户
    @Override
    public List<UserAndJob> selectResumeByJob(int jobid) {
        return checkResumeDao.selectResumeByJob(jobid);
    }
    //HR 删除简历
    @Override
    public int deleteResumeByUserId(int userid) {
        return checkResumeDao.deleteResumeByUserId(userid);
    }
    //根据用户id查简历
    @Override
    public Resume selectResumeByuserId(int userid) {
        return selectResumeClient.sff(userid);
    }
}
