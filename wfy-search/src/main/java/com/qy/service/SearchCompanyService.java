package com.qy.service;

import com.qy.pojo.search.BaseResp;

import java.io.IOException;

public interface SearchCompanyService {
    //根据公司名进行查询
    BaseResp searchByCompanyName(String index, Integer page, Integer size) throws IOException;

    //根据省份进行查询
    BaseResp searchCompanByProvince(String index, Integer page, Integer size) throws IOException;

    //根据市进行查询
    BaseResp searchCompanByCity(String index, Integer page, Integer size) throws IOException;

    //根据职位查公司
    BaseResp searchCompanByJob(String index, Integer page, Integer size) throws IOException;
}
