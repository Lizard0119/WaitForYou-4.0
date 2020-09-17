package com.qy.service.impl;

import com.qy.dao.CompanyDao;
import com.qy.pojo.search.Company;
import com.qy.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyDao dao;

    @Override
    public String insertCompany(Company company) {
        return dao.createCompany(company) ? "success" : "failed";
    }

    @Override
    public Integer findCid(Integer bid) {
        return dao.findCompanyId(bid);
    }
}
