package com.qy.controller;

import com.qy.pojo.user.Boss;
import com.qy.service.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BossController {

    @Autowired
    BossService service;

    @RequestMapping("/createBoss")
    public String createBoss(@RequestBody Boss boss) {
        return service.insertBoss(boss);
    }


}
