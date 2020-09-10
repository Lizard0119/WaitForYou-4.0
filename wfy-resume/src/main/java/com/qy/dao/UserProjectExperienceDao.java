package com.qy.dao;

import com.qy.pojo.resume.UserProjectExperience;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserProjectExperienceDao {


    //查询所有的项目经验和用户的联合表
    List<UserProjectExperience> findResumeByUserProjectExperienceId(Integer userId);
    //修改项目经验和用户的联合表
    Integer updateResumeByUserProjectExperienceId(UserProjectExperience userProjectExperience);
    //添加新的项目经验和用户的联合表
    Integer saveResumeUserProjectExperience(UserProjectExperience userProjectExperience);
    //删除项目经验和用户的联合表
    Integer deleteResumeByUserProjectExperienceId(Integer projectExperienceId);
}
