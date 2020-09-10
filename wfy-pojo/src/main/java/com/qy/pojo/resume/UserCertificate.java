package com.qy.pojo.resume;

import lombok.Data;

//用户证书关联表
@Data
public class UserCertificate {
    //资格证书id
    private Integer certificateId;
    //用户id
    private Integer userId;
}
