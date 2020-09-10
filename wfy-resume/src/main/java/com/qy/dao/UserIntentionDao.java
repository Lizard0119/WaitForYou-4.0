package com.qy.dao;

import com.qy.pojo.resume.Intention;
import com.qy.pojo.resume.UserIntention;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserIntentionDao {


    //查询所有的求职意向和用户的联合表
    List<Intention> findResumeByUserIntentionId(Integer userId);
    //修改求职意向和用户的联合表
    Integer updateResumeByUserIntentionId(UserIntention userIntention);
    //添加新的求职意向和用户的联合表
    Integer saveResumeUserIntention(UserIntention userIntention);
    //删除求职意向和用户的联合表
    Integer deleteResumeByUserIntentionId(Integer IntentionId);
}
