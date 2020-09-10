package com.qy.pojo.resume;

import lombok.Data;

//用户工作经历关联表
@Data
public class UserWorkExperience {
    //工作经历id
    private Integer workExperienceId;
    //用户id
    private Integer userId;
}
