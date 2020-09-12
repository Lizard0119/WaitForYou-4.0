package com.qy.service.impl;

import com.qy.dao.IInterviewCompanyDao;
import com.qy.pojo.interview.InterviewCompany;
import com.qy.service.IInterviewCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterviewCompanyServiceImpl implements IInterviewCompanyService {


    @Autowired
    private IInterviewCompanyDao interviewCompanyDao;

    @Override
    public boolean saveInterviewCompany(InterviewCompany interviewCompany) {
        return interviewCompanyDao.saveInterviewCompany(interviewCompany) > 0;
    }

    @Override
    public boolean removeInterviewCompany(InterviewCompany interviewCompany) {
        return interviewCompanyDao.removeInterviewCompany(interviewCompany) > 0;
    }
}
