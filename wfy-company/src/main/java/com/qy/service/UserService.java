package com.qy.service;

import com.qy.pojo.user.User;

public interface UserService {

    String changeUser(User user);

    User getUser(int id);

    User getUserIdentifyId(int id);
}
