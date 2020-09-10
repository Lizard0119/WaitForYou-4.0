package com.qy.pojo.resume;


import lombok.Data;

import java.util.Date;

//项目经验
@Data
public class ProjectExperience {

    //项目经验id
    private int projectExperienceId;
    //项目名称
    private String projectExperienceName;
    //项目角色
    private String projectExperienceRole;
    //项目开始时间
    private Date projectExperienceLastTime;
    //项目结束时间
    private Date projectExperienceBeforeTime;
    //项目描述
    private String projectExperienceDescribe;
    //项目业绩
    private String projectExperiencePerformance;
    //项目链接
    private String projectExperienceConnect;

}
