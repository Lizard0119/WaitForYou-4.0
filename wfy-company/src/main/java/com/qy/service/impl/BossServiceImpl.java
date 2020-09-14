package com.qy.service.impl;

import com.qy.dao.BossDao;
import com.qy.pojo.user.Boss;
import com.qy.service.BossService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BossServiceImpl implements BossService {

    @Resource
    BossDao dao;

    @Override
    public String insertBoss(Boss boss) {
        return dao.createBoss(boss) ? "success" : "failed";
    }
}
