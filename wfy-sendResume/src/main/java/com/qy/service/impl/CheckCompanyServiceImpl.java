package com.qy.service.impl;

import com.qy.dao.CheckCompanyDao;
import com.qy.pojo.search.Company;
import com.qy.pojo.sendresume.CompanyJobHR;
import com.qy.service.CheckCompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Hz
 * 2020/9/17
 */
@Service
public class CheckCompanyServiceImpl implements CheckCompanyService {
    @Resource
    private CheckCompanyDao companyDao;
    @Override
    public Company selectCompanyByBossid(int bossid) {
        return companyDao.selectCompanyByBossid(bossid);
    }

    @Override
    public CompanyJobHR getcompanyJobHR(int userid) {
        return companyDao.getcompanyJobHR(userid);
    }
}
