package com.qy.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "tb_company")
@Entity
public class CompanyJPA {
    // 公司id
    @Id
    @Column(name = "company_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer companyId;
    // 公司名
    @Column(name = "company_name")
    private String companyName;
    // 公司名简称
    @Column(name = "company_shortname")
    private String companyShortName;
    // 公司简介
    @Column(name = "company_profile")
    private String companyProfile;
    // 公司地址
    @Column(name = "company_address")
    private String companyAddress;
    // 公司老板
    @Column(name = "company_boss")
    private String companyBoss;
    // 注册资本
    @Column(name = "company_registered_capital")
    private String companyRegisteredCapital;
    // 公司成立时间
    @Column(name = "company_date")
    private Date companyDate;
    // 公司头像
    @Column(name = "company_img")
    private String companyImg;
    // 统一信用代码
    @Column(name = "company_code")
    private String companyCode;
    // 经营范围
    @Column(name = "company_business_scope")
    private String companyBusinessScope;
    // 经营状态，默认为1（1正常/0异常）
    @Column(name = "company_status")
    private Integer companyStatus;
    // 公司视频简介
    @Column(name = "company_vcr")
    private String companyVcr;
    //公司规模（默认0）0不限/1（0-20）/2（20-99）/3（100-499）/4（500-999）/5（1000-9999）/6（10000+）
    @Column(name = "company_scale")
    private Integer companyScale;
    //融资阶段（默认0）0不限/1未融资/2天使轮/3A轮/4B轮/5C轮/6D轮及以上/7已上市/8不需要融资
    @Column(name = "company_financing")
    private Integer companyFinancing;
    //更新时间
    @Column(name = "company_updatetime")
    private Date companyUpdatetime;
}
