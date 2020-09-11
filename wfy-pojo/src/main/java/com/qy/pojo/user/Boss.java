package com.qy.pojo.user;

import lombok.Data;

/**
 * @author Hz
 * 2020/9/10
 *
 * boss表 HR信息
 */
@Data
public class Boss {
    private int bossId; //id
    private String bossName;    //姓名
    private String bossSex; //性别
    private String bossPhone;   //联系方式
    private int bossCompanyId;  //所属公司 公司id
}
