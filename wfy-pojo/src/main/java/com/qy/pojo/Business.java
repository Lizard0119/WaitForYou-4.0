package com.qy.pojo;

import lombok.Data;

/**
 * 这是公司行业表
 */
@Data
public class Business {
    //行业id
    //数据库叫  business_id
    private Integer businessId;
    //行业名称
    //数据库叫  business_name
    private String businessName;
}
