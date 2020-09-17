package com.qy.controller;

import com.qy.pojo.search.Company;
import com.qy.service.CheckCompanyService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Hz
 * 2020/9/17
 */
@RestController
public class CheckCompanyController {
    @Resource
    private CheckCompanyService checkCompanyService;
    @RequestMapping("/companybyhid/{bossid}")
    public Company selectCompanyByBossid(@PathVariable("bossid") int bossid){
        return checkCompanyService.selectCompanyByBossid(bossid);

    }
}
