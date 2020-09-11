package com.qy.pojo.sendresume;

import lombok.Data;

/**
 * @author Hz
 * 2020/9/11
 *
 *
 * 简历 职位 关联表
 */
@Data
public class ResumeAndJob {
    private int resumeId;
    private int jobId;
}
