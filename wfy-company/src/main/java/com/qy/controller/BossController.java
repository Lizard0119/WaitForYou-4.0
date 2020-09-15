package com.qy.controller;

import com.qy.pojo.job.Job;
import com.qy.pojo.user.Boss;
import com.qy.service.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BossController {

    @Autowired
    BossService service;

    @RequestMapping("/createBoss")
    public String createBoss(@RequestBody Boss boss) {
        return service.insertBoss(boss);
    }

    @RequestMapping("/inviteJob")
    public String inviteJob(@RequestBody Job job) {
        return service.inviteJob(job);
    }

    @RequestMapping("/bossJob")
    public String bossJob(@RequestBody Map map) {
        Integer bid = (Integer) map.get("bid");
        Integer jid = (Integer) map.get("jid");

        return service.bossJob(bid, jid);
    }
}
