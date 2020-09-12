package com.qy.service;

import com.qy.pojo.interview.InterviewCompany;

public interface IInterviewCompanyService {
    boolean saveInterviewCompany(InterviewCompany interviewCompany);

    boolean removeInterviewCompany(InterviewCompany interviewCompany);
}
