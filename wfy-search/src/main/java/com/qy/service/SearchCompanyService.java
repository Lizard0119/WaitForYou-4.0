package com.qy.service;

import com.qy.pojo.BaseResp;

import java.io.IOException;

public interface SearchCompanyService {
    //根据公司名进行查询
    BaseResp searchByCompanyName(String index) throws IOException;

    //根据省份进行查询
    BaseResp searchCompanByProvince(String index) throws IOException;

    //根据市进行查询
    BaseResp searchCompanByCity(String index) throws IOException;
}
