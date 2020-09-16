package com.qy.service.impl;

import com.qy.dao.CheckResumeDao;
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
    private CheckResumeDao checkResumeDao;
    @Override
    public List<UserAndJob> selectResumeByJob(int jobid) {
        return checkResumeDao.selectResumeByJob(jobid);
    }

    @Override
    public int deleteResumeByUserId(int userid) {
        return checkResumeDao.deleteResumeByUserId(userid);
    }
}
