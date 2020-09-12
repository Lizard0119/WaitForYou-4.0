package com.qy.controller;

import com.qy.pojo.interview.dto.UserInterviewCompany;
import com.qy.service.IUserInterviewCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInterviewCompanyController {

    @Autowired
    private IUserInterviewCompanyService userInterviewCompanyService;
    @GetMapping("/findAllUserInterviewCompany/{userId}")
    public List<UserInterviewCompany> findAllUserInterviewCompany(@PathVariable("userId") Integer userId) {
        return userInterviewCompanyService.findAllUserInterviewCompany(userId);
    }
}
