package com.qy.service.impl;

import com.qy.dao.UserDao;
import com.qy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao dao;

    @Override
    public String changeUser(String id) {
        return dao.changeUser(id) ? "success" : "failed";
    }
}
