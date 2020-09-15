package com.qy.service.impl;

import com.qy.dao.UserBossDao;
import com.qy.service.UserBossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBossServiceImpl implements UserBossService {

    @Autowired
    UserBossDao dao;

    @Override
    public String insertUB(Integer userid, Integer bossid) {
        return dao.insertUB(userid, bossid)?"success":"failed";
    }
}
