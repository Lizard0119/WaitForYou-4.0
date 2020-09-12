package com.qy.dao;

import com.qy.pojo.interview.Interview;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IInterviewDao {

    Integer saveInterview(Interview interview);

    Integer removeInterview(Integer interviewId);

}
