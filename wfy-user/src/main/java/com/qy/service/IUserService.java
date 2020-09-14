package com.qy.service;

import com.qy.pojo.user.User;
import com.qy.pojo.user.UserReq;

public interface IUserService {
    String login(User user);

    String register(UserReq userReq);
}
