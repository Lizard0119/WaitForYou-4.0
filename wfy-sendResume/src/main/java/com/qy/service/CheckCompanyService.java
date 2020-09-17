package com.qy.service;

import com.qy.pojo.search.Company;

/**
 * @author Hz
 * 2020/9/17
 */

public interface CheckCompanyService {
   Company selectCompanyByBossid(int bossid);
}
