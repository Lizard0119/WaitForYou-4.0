package com.qy.dao;

import com.qy.pojo.search.Company;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyDao {

    //注册公司信息
    boolean createCompany(Company company);

}
