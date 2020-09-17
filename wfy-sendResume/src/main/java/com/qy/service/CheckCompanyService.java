package com.qy.service;

import com.qy.pojo.search.Company;
import com.qy.pojo.sendresume.CompanyJobHR;

/**
 * @author Hz
 * 2020/9/17
 */

public interface CheckCompanyService {
   Company selectCompanyByBossid(int bossid);

    CompanyJobHR getcompanyJobHR(int userid);
}
