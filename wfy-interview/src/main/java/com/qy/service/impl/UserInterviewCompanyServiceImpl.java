package com.qy.service.impl;

import com.qy.dao.IUserInterviewCompanyDao;
import com.qy.pojo.interview.dto.UserInterviewCompany;
import com.qy.service.IUserInterviewCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInterviewCompanyServiceImpl implements IUserInterviewCompanyService {

    @Autowired
    private IUserInterviewCompanyDao userInterviewCompanyDao;

    @Override
    public List<UserInterviewCompany> findAllUserInterviewCompany(Integer userId) {
        return userInterviewCompanyDao.findAllUserInterviewCompany(userId);
    }
}
