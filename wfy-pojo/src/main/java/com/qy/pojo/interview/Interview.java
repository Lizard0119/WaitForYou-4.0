package com.qy.pojo.interview;

import lombok.Data;

/**
 * 面试表
 */
@Data
public class Interview {
    // 面试ID
    private String interviewId;
    // 面试时间
    private String interviewData;
    // 面试地点
    private String interviewSite;
    // 联系人姓名
    private String interviewContactName;
    // 联系人电话
    private String interviewTelephone;
}
