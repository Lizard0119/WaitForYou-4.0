package com.qy.pojo.resume;


import lombok.Data;

import java.util.Date;

//教育经历
@Data
public class ResumeEducation {

    //教育经历id
    private int resumeEducationId;

    //学校
    private String resumeEducationSchool;

    //学历
    private String resumeEducationBackground;

    //专业
    private String resumeEducationMajor;

    //结束时间
    private Date resumeEducationLastTime;

    //开始时间
    private Date resumeEducationBeforeTime;

    //在校经历
    private String resumeEducationExperience;

}
