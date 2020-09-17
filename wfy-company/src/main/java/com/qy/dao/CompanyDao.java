package com.qy.dao;

import com.qy.pojo.search.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CompanyDao {

    //注册公司信息
    boolean createCompany(Company company);

    //通过用户ID查询公司ID
    Integer findCompanyId(@Param("bid") Integer bid);
}
