package com.qy.dao;


import com.qy.pojo.resume.Intention;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface IntentionDao {

    //查询所有的求职意向
    List<Intention> findResumeByIntentionId(Integer uesrId);
    //修改求职意向
    Integer updateResumeByIntentionId(Intention intention);
    //添加新的求职意向
    Integer saveResumeIntention(Intention intention);
    //删除求职意向
    Integer deleteResumeByIntentionId(Integer intentionId);
}
