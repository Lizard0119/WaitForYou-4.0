package com.qy.dao;

import com.qy.pojo.interview.InterviewUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IInterviewUserDao {

    Integer saveInterviewUser(InterviewUser interviewUser);

    Integer removeInterviewUser(InterviewUser interviewUser);
}
