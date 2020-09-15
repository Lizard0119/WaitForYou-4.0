package com.qy.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    //通过user的ID来找到用户进行身份的变更
    boolean changeUser(@Param("id") String id);


}
