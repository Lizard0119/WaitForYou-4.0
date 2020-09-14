package com.qy.controller;


import com.qy.pojo.search.BaseResp;
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
    @RequestMapping("/searchCompanyByname/{index}/{page}/{size}")
    public BaseResp searchCompanyByname(@PathVariable("index") String index,@PathVariable("page")Integer page,@PathVariable("size")Integer size) throws IOException {
        return searchCompanyService.searchByCompanyName(index,page,size);
    }

    //根据省来查询
    @RequestMapping("/searchCompanByProvince/{index}/{page}/{size}")
    public BaseResp searchCompanByProvince(@PathVariable("index") String index,@PathVariable("page")Integer page,@PathVariable("size")Integer size) throws IOException {
        return searchCompanyService.searchCompanByProvince(index,page,size);
    }

    //根据市来查询
    @RequestMapping("/searchCompanByCity/{index}/{page}/{size}")
    public BaseResp searchCompanByCity(@PathVariable("index") String index,@PathVariable("page")Integer page,@PathVariable("size")Integer size) throws IOException {
        return searchCompanyService.searchCompanByCity(index,page,size);
    }

    //根据职位来查询
    @RequestMapping("/searchCompanByJob/{index}/{page}/{size}")
    public BaseResp searchCompanByJob(@PathVariable("index") String index,@PathVariable("page")Integer page,@PathVariable("size")Integer size) throws IOException {
        return searchCompanyService.searchCompanByJob(index,page,size);
    }
}
