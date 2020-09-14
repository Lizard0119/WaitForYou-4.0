package com.qy.pojo.user;

import lombok.Data;

@Data
public class UserReq {

    private String username;
    private String password;
    private String userEmail;
    private String code;
}
