package com.qy.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserBossDao {

    boolean insertUB(@Param("uid") Integer userid, @Param("bid") Integer bossid);
}
