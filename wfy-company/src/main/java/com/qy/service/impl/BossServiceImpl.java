package com.qy.service.impl;

import com.qy.dao.BossDao;
import com.qy.pojo.job.Job;
import com.qy.pojo.user.Boss;
import com.qy.service.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BossServiceImpl implements BossService {

    @Resource
    BossDao dao;

    @Override
    public String insertBoss(Boss boss) {
        return dao.createBoss(boss) ? "success" : "failed";
    }

    @Override
    public String inviteJob(Job job) {
        return dao.inviteJob(job) ? "success" : "failed";
    }

    @Override
    public String bossJob(Integer bid, Integer jid) {
        return dao.bossJob(bid, jid) ? "success" : "failed";
    }

    @Override
    public List<Job> searchAllMyJob(Integer bid) {
        return dao.searchAllMyJob(bid);
    }

    @Override
    public List<Boss> findMine(Integer bid) {
        return dao.findMine(bid);
    }
}
