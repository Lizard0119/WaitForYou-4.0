package com.qy.pojo;

import lombok.Data;

/*
wwh
2020/9/9
 */
@Data
public class Province {
    //省份ID
    //数据库叫 province_id
    private Integer provinceId;
    //省份名称
    //数据库叫 province_name
    private String provinceName;
}
