package com.qy.controller;

import com.qy.pojo.search.Company;
import com.qy.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @RequestMapping("/createCompany")
    public String createCompany(@RequestBody Company company) {
        return companyService.insertCompany(company);
    }

    @RequestMapping("/findCid")
    public Integer findCid(@RequestBody Map map) {
        Integer bid = (Integer) map.get("bid");

        return companyService.findCid(bid);
    }
}
