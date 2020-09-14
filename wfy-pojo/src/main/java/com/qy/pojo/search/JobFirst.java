package com.qy.pojo.search;

import lombok.Data;

/**
 * job第一职位表
 * wwh
 * 2020/9/9
 */
@Data
public class JobFirst {
    //职位表一
    //数据库叫 jobtable_fid
    private Integer jobTableFid;
    //职位表一的类型名
    //数据库叫 jobtable_fisttype
    private String jobTableFistType;

    //职位表二类型,为了配合findByFirstAndSecondJob方法
    // （wfy.search.src.main.resources.mapper.FirstAndSecondJobSearchMapper.xml）
    //数据库叫 jobtabel_secondtype
    private String jobTabelSecondType;
}
