package com.qy.service;

import com.qy.pojo.job.Job;
import com.qy.pojo.user.Boss;

import java.util.List;

public interface BossService {

    String insertBoss(Boss boss);

    String inviteJob(Job job);

    String bossJob(Integer bid, Integer jid);

    List<Job> searchAllMyJob(Integer bid);

    List<Boss> findMine(Integer bid);
}
