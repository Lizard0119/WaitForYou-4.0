package com.qy.controller;

import com.qy.service.UserBossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserBossConyroller {

    @Autowired
    UserBossService service;

    @RequestMapping("/insertUB")
    public String insertUB(@RequestBody Map map) {
        Integer uid = (Integer) map.get("uid");
        Integer bid = (Integer) map.get("bid");

        return service.insertUB(uid, bid);
    }


}
