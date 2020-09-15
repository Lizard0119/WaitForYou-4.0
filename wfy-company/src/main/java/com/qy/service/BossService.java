package com.qy.service;

import com.qy.pojo.job.Job;
import com.qy.pojo.user.Boss;

public interface BossService {

    String insertBoss(Boss boss);

    String inviteJob(Job job);

    String bossJob(Integer bid, Integer jid);
}
