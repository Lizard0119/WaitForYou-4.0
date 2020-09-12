package com.qy.service.impl;

import com.qy.dao.IInterviewUserDao;
import com.qy.pojo.interview.InterviewUser;
import com.qy.service.IInterviewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterviewUserServiceImpl implements IInterviewUserService {

    @Autowired
    private IInterviewUserDao interviewUserDao;

    @Override
    public boolean saveInterviewUser(InterviewUser interviewUser) {
        return interviewUserDao.saveInterviewUser(interviewUser) > 0;
    }

    @Override
    public boolean removeInterviewUser(InterviewUser interviewUser) {
        return interviewUserDao.removeInterviewUser(interviewUser) > 0;
    }
}
