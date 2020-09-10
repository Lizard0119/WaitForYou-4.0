package com.qy.dao;

import com.qy.pojo.resume.WorkExperience;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkExperienceDao {
    //通过用户id查询工作经历
    List<WorkExperience> findResumeByWorkExperienceUserId(Integer userId);

    //工作经历增加方法
    int saveWorkExperience(WorkExperience workExperience);
    //工作经历删除方法
    int deleteWorkExperienceById(Integer workExperienceId);
    //通过工作经历id工作经历修改方法
    int updateWorkExperience(WorkExperience workExperience);


}
