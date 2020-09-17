package com.qy.service;

import com.qy.pojo.user.User;
import com.qy.pojo.user.UserReq;

import java.util.Map;

public interface IUserService {
    Map login(User user);

    String register(UserReq userReq);

    User getUserById(int userid);

    String updateUser(User user);
}
