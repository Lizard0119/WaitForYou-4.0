package com.qy.dao;

import com.qy.pojo.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IUserDao {

    User findByUsername(@Param("username") String username);

    int Register(User user);

    User getUserById(int userid);

    int updateUser(User user);
}
