package com.qy.pojo.user;

import lombok.Data;

import java.util.Date;

/**
 * @author Hz
 * 2020/9/10
 */
@Data
public class User {
    private int userid;
    private String userEmail;
    private String password;
    private String username;
    private int userSex;
    private String userIdentity;// 用户身份 求职者/boss
    private String userAvatar;
    private Date userBirthday;
    private int userPoliyicsStatus;//政治面貌
    private int userJobState;
    private Date userCreateTime;
    private String userAddress;

}
