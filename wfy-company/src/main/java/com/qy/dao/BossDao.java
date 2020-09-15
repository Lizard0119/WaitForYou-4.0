package com.qy.dao;

import com.qy.pojo.job.Job;
import com.qy.pojo.user.Boss;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BossDao {

    //创建Boss名片
    boolean createBoss(Boss boss);

    //发布招聘信息
    boolean inviteJob(Job job);

    //将招聘信息与boss进行关联
    boolean bossJob(@Param("bid") Integer bid, @Param("jid") Integer jid);
}
