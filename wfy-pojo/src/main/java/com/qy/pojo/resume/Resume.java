package com.qy.pojo.resume;

import com.qy.pojo.user.User;
import lombok.Data;

import java.util.List;

@Data
public class Resume {
    private User user;
    private List<Certificate> certificate;
    private List<Intention> intention;
    private List<ProjectExperience> projectExperience;
    private List<ResumeEducation> resumeEducation;
    private List<Social> social;
    private List<WorkExperience> workExperience;
}
