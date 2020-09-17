package com.qy.service;

import com.qy.pojo.search.Company;

public interface CompanyService {

    String insertCompany(Company company);

    Integer findCid(Integer bid);
}
