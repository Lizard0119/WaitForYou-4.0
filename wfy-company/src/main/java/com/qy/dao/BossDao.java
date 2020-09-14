package com.qy.dao;

import com.qy.pojo.user.Boss;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BossDao {

    //创建Boss名片
    boolean createBoss(Boss boss);

}
