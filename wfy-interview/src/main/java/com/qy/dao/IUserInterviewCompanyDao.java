package com.qy.dao;

import com.qy.pojo.interview.dto.UserInterviewCompany;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUserInterviewCompanyDao {
    List<UserInterviewCompany> findAllUserInterviewCompany(Integer userId);
}
