package com.qy.service.impl;

import com.qy.dao.SendResumeDao;
import com.qy.service.SendResumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Hz
 * 2020/9/10
 */
@Service
public class SendResumeServiceImpl implements SendResumeService {

   @Resource
  private SendResumeDao sendResumeDao;

    @Override
    public int insertWithUserAndJob(int userid, int jobid) {
        return sendResumeDao.insertWithUserAndJob(userid, jobid);
    }
}
