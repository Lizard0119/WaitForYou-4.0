package com.qy.dao;

import com.qy.pojo.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IUserDao {

    @Select("select * from tb_user where username= #{username}")
    User findByUsername(@Param("username") String username);

//    @Select("select * from tb_user where username=#{username} and user_email=#{user_email}")
//    User findByUsernameAndEmail(User user);
}