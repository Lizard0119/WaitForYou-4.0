package com.qy.service;

import com.qy.pojo.CompanyJPA;
import com.qy.pojo.MapJPA;
import com.qy.pojo.search.BaseResp;

public interface CompanyJPAService {
    CompanyJPA findAllById(Integer id);

    BaseResp findAllCompany(Integer page, Integer size);

    MapJPA findMapByCompanyId(Integer id);
}
