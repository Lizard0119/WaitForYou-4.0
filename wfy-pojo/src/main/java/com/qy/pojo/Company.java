package com.qy.pojo;

import lombok.Data;

import java.util.Date;

/*
wwh
2020/9/9
 */
@Data
public class Company {
    // 公司id
    //数据库叫  company_id
    private Integer companyId;
    // 公司名
    //数据库叫  company_name
    private String companyName;
    // 公司名简称
    //数据库叫  company_shortname
    private String companyShortName;
    // 公司简介
    //数据库叫  company_profile
    private String companyProfile;
    // 公司地址
    //数据库叫  company_address
    private String companyAddress;
    // 公司老板
    //数据库叫  company_boss
    private String companyBoss;
    // 注册资本
    //数据库叫  company_registered_capital
    private String companyRegisteredCapital;
    // 公司成立时间
    //数据库叫  company_date
    private Date companyDate;
    // 公司头像
    //数据库叫  company_img
    private String companyImg;
    // 统一信用代码
    //数据库叫  company_code
    private String companyCode;
    // 经营范围
    //数据库叫  company_business_scope
    private String companyBusinessScope;
    // 经营状态，默认为1（1正常/0异常）
    //数据库叫  company_status
    private Integer companyStatus;
    // 公司视频简介
    //数据库叫  company_vcr
    private String companyVcr;
    //公司规模（默认0）0不限/1（0-20）/2（20-99）/3（100-499）/4（500-999）/5（1000-9999）/6（10000+）
    //数据库叫  company_scale
    private Integer companyScale;
    //融资阶段（默认0）0不限/1未融资/2天使轮/3A轮/4B轮/5C轮/6D轮及以上/7已上市/8不需要融资
    //数据库叫  company_financing
    private Integer companyFinancing;
}
