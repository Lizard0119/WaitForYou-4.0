package com.qy.service.impl;

import com.qy.dao.UserDao;
import com.qy.pojo.user.User;
import com.qy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao dao;

    @Override
    public String changeUser(User user) {
        return dao.changeUser(user) ==1? "success" : "failed";
    }

    @Override
    public User getUser(int id) {
        return dao.getUser(id);
    }

    @Override
    public User getUserIdentifyId(int id) {
        return dao.getUserIdentifyId(id);
    }
}
