package com.qy.pojo.search;

import lombok.Data;

/**
 * job第二职位表
 * wwh
 * 2020/9/9
 */
@Data
public class JobSecond {
    //职位表二
    //数据库叫 jobtable_sid
    private Integer jobTableSid;
    //职位表二类型
    //数据库叫 jobtabel_secondtype
    private String jobTabelSecondType;
    //jobimg
    private String jobimg;
}
