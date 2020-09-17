package com.qy.dao;

import com.qy.pojo.search.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Hz
 * 2020/9/17
 */
@Mapper
public interface CheckCompanyDao {
    //通过HR id查询 公司
    Company selectCompanyByBossid(@Param("bossid") int bossid);
}
