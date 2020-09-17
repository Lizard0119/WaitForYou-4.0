package com.qy.pojo.company.dto;

import lombok.Data;

@Data
public class BossCompany {
    private int bossId; //id
    private String bossName;    //姓名
    private String bossSex; //性别
    private String bossPhone;   //联系方式
    private int bossCompanyId;  //所属公司 公司id
    // 公司id
    //数据库叫  company_id
    private Integer companyId;
    // 公司名
    //数据库叫  company_name
    private String companyName;
    // 公司名简称
    //数据库叫  company_shortname
    private String companyShortName;
}
