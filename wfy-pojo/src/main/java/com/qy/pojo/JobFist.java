package com.qy.pojo;

import lombok.Data;

/**
 * job第一职位表
 * wwh
 * 2020/9/9
 */
@Data
public class JobFist {
    //职位表一
    //数据库叫 jobtable_fid
    private Integer jobTableFid;
    //职位表一的类型名
    //数据库叫 jobtable_fisttype
    private String jobTableFistType;
}
