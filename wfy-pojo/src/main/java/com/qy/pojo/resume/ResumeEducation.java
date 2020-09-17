package com.qy.pojo.resume;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//教育经历
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public int getResumeEducationId() {
        return resumeEducationId;
    }

    public void setResumeEducationId(int resumeEducationId) {
        this.resumeEducationId = resumeEducationId;
    }

    public String getResumeEducationSchool() {
        return resumeEducationSchool;
    }

    public void setResumeEducationSchool(String resumeEducationSchool) {
        this.resumeEducationSchool = resumeEducationSchool;
    }

    public String getResumeEducationBackground() {
        return resumeEducationBackground;
    }

    public void setResumeEducationBackground(String resumeEducationBackground) {
        this.resumeEducationBackground = resumeEducationBackground;
    }

    public String getResumeEducationMajor() {
        return resumeEducationMajor;
    }

    public void setResumeEducationMajor(String resumeEducationMajor) {
        this.resumeEducationMajor = resumeEducationMajor;
    }

    public Date getResumeEducationLastTime() {
        return resumeEducationLastTime;
    }

    public void setResumeEducationLastTime(Date resumeEducationLastTime) {
        this.resumeEducationLastTime = resumeEducationLastTime;
    }

    public Date getResumeEducationBeforeTime() {
        return resumeEducationBeforeTime;
    }

    public void setResumeEducationBeforeTime(Date resumeEducationBeforeTime) {
        this.resumeEducationBeforeTime = resumeEducationBeforeTime;
    }

    public String getResumeEducationExperience() {
        return resumeEducationExperience;
    }

    public void setResumeEducationExperience(String resumeEducationExperience) {
        this.resumeEducationExperience = resumeEducationExperience;
    }

    //开始时间
    private Date resumeEducationBeforeTime;

    //在校经历
    private String resumeEducationExperience;


}
