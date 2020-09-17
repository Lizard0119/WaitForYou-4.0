package com.qy.pojo.search;

import lombok.Data;

@Data
public class CompanyES {
    //公司ID
    private Integer companyid;
    //公司名
    private String companyname;
    //公司别名
    private String companyshortname;
    //行业
    private String businessname;
    //公司规模（默认0）0不限/1（0-20）/2（20-99）/3（100-499）/4（500-999）/5（1000-9999）/6（10000+）
    private Integer companyscale;
    //省
    private String province;
    //市
    private String city;
    //融资阶段（默认0）0不限/1未融资/2天使轮/3A轮/4B轮/5C轮/6D轮及以上/7已上市/8不需要融资
    private Integer companyfinancing;
    //职位
    private String jobname;
    //公司图片
    private String companyimg;

}
