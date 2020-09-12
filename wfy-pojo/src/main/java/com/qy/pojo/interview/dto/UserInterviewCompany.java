package com.qy.pojo.interview.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserInterviewCompany {
    // 公司名称
    private String companyName;
    // 公司地址
    private String companyAddress;
    // 岗位ID
    private Integer jobId;
    // 岗位
    private String jobName;
    // 薪资
    private String jobPay;
    // 面试时间
    private Date interviewData;
    // 面试地点
    private String interviewSite;
    // 联系人姓名
    private String interviewContactName;
    // 联系人电话
    private String interviewTelephone;
}
