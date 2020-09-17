package com.qy.dao;

import com.qy.pojo.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    //通过user的ID来找到用户进行身份的变更
    int changeUser(User user);

    User getUser(@Param("userid") int id);

    //查找当前用户的身份代码
    User getUserIdentifyId(@Param("userid") int userId);
}
