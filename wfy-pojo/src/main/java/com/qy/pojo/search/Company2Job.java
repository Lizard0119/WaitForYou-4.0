package com.qy.pojo.search;

import lombok.Data;

@Data
public class Company2Job {
    // 公司id
    //数据库叫  company_id
    private Integer companyId;
    //职位表二
    //数据库叫 jobtable_sid
    private Integer jobTableSid;
    //职位表二类型
    //数据库叫 jobtabel_secondtype
    private String jobTabelSecondType;
    //jobimg
    private String jobimg;
}
