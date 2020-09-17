package com.qy.controller;


import com.qy.pojo.CompanyJPA;
import com.qy.pojo.MapJPA;
import com.qy.pojo.search.BaseResp;
import com.qy.service.CompanyJPAService;
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

    @Autowired
    CompanyJPAService companyJPAService;

    @RequestMapping("/findMapByCompanyId/{id}")
    public MapJPA findMapByCompanyId(@PathVariable("id") Integer id) {
        return companyJPAService.findMapByCompanyId(id);
    }

    @RequestMapping("/findAllCompany/{page}/{size}")
    public BaseResp findAllCompany(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return companyJPAService.findAllCompany(page, size);
    }

    @RequestMapping("/findCompanyById/{id}")
    public CompanyJPA findCompanyById(@PathVariable("id") Integer id) {
        return companyJPAService.findAllById(id);
    }

    //根据公司名进行查询
    @RequestMapping("/searchCompanyByname/{index}/{page}/{size}")
    public BaseResp searchCompanyByname(@PathVariable("index") String index, @PathVariable("page") Integer page, @PathVariable("size") Integer size) throws IOException {
        return searchCompanyService.searchByCompanyName(index, page, size);
    }

    //根据省来查询
    @RequestMapping("/searchCompanByProvince/{index}/{page}/{size}")
    public BaseResp searchCompanByProvince(@PathVariable("index") String index, @PathVariable("page") Integer page, @PathVariable("size") Integer size) throws IOException {
        return searchCompanyService.searchCompanByProvince(index, page, size);
    }

    //根据市来查询
    @RequestMapping("/searchCompanByCity/{index}/{page}/{size}")
    public BaseResp searchCompanByCity(@PathVariable("index") String index, @PathVariable("page") Integer page, @PathVariable("size") Integer size) throws IOException {
        return searchCompanyService.searchCompanByCity(index, page, size);
    }

    //根据职位来查询
    @RequestMapping("/searchCompanByJob/{index}/{page}/{size}")
    public BaseResp searchCompanByJob(@PathVariable("index") String index, @PathVariable("page") Integer page, @PathVariable("size") Integer size) throws IOException {
        return searchCompanyService.searchCompanByJob(index, page, size);
    }
}
