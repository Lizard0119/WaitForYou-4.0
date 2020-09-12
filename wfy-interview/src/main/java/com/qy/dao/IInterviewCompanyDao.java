package com.qy.dao;

import com.qy.pojo.interview.InterviewCompany;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IInterviewCompanyDao {

    Integer saveInterviewCompany(InterviewCompany interviewCompany);

    Integer removeInterviewCompany(InterviewCompany interviewCompany);
}
