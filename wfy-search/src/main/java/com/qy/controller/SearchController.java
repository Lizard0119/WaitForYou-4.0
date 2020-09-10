package com.qy.controller;


import com.qy.pojo.BaseResp;
import com.qy.service.SearchCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    SearchCompanyService searchCompanyService;

    //根据公司名进行查询
    @RequestMapping("/searchCompanyByname/{index}")
    public BaseResp searchCompanyByname(@PathVariable("index") String index) throws IOException {
        return searchCompanyService.searchByCompanyName(index);
    }

    //根据省来查询
    @RequestMapping("/searchCompanByProvince/{index}")
    public BaseResp searchCompanByProvince(@PathVariable("index") String index) throws IOException {
        return searchCompanyService.searchCompanByProvince(index);
    }

    //根据市来查询
    @RequestMapping("/searchCompanByCity/{index}")
    public BaseResp searchCompanByCity(@PathVariable("index") String index) throws IOException {
        return searchCompanyService.searchCompanByCity(index);
    }
}
