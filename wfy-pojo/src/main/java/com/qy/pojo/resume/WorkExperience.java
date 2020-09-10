package com.qy.pojo.resume;

import lombok.Data;

import java.util.Date;

//工作经历表
@Data
public class WorkExperience {

    //工作经历id
    private Integer workExperienceId;
    //公司名称
    private String workExperienceCompany;
    //所在行业
    private String workExperienceIndustry;
    //在职开始时间
    private Date workExperienceWorkingTimeBegin;
    //在职结束时间
    private Date workExperienceWorkingTimeEnd;
    //职位类型
    private String workExperienceType;
    //所属部门
    private String workExperienceDepartment;
    //工作内容
    private String workExperienceContent;
    //工作业绩
    private String workExperiencePerformance;
}
