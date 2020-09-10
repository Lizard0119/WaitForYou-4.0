package com.qy.pojo.resume;

import lombok.Data;

//求职意向表
@Data
public class Intention {

    //求职意向id
    private int intentionId;
    //求职状态
    private String intentionStatus;
    //期望职位
    private String intentionPosition;
    //期望行业
    private String intentionBusiness;
    //工作城市
    private String intentionCity;
    //薪资要求
    private String intentionPersonally;
}
