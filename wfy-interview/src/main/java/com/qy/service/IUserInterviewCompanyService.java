package com.qy.service;

import com.qy.pojo.interview.dto.UserInterviewCompany;

import java.util.List;

public interface IUserInterviewCompanyService {
    List<UserInterviewCompany> findAllUserInterviewCompany(Integer userId);
}
