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
public class UserAndJob {
    private int userId;
    private int jobId;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public UserAndJob() {
    }

    public UserAndJob(int userId, int jobId) {
        this.userId = userId;
        this.jobId = jobId;
    }
}
