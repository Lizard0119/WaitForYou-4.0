package com.qy.pojo.job;

import lombok.Data;

import java.util.Date;

@Data
public class Job {
    private Integer jobId;
    private String jobName;
    private String jobPay;
    private String jobSketch;
    private String jobDes;
    private Date jobCreateTime;
    private Integer jobStatues;
    private String jobReserved;
    private String jobReservedl;

    public Job() {
    }

    public Job(Integer jobId, String jobName, String jobPay) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobPay = jobPay;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobPay() {
        return jobPay;
    }

    public void setJobPay(String jobPay) {
        this.jobPay = jobPay;
    }

    public String getJobSketch() {
        return jobSketch;
    }

    public void setJobSketch(String jobSketch) {
        this.jobSketch = jobSketch;
    }

    public String getJobDes() {
        return jobDes;
    }

    public void setJobDes(String jobDes) {
        this.jobDes = jobDes;
    }

    public Date getJobCreateTime() {
        return jobCreateTime;
    }

    public void setJobCreateTime(Date jobCreateTime) {
        this.jobCreateTime = jobCreateTime;
    }

    public Integer getJobStatues() {
        return jobStatues;
    }

    public void setJobStatues(Integer jobStatues) {
        this.jobStatues = jobStatues;
    }

    public String getJobReserved() {
        return jobReserved;
    }

    public void setJobReserved(String jobReserved) {
        this.jobReserved = jobReserved;
    }

    public String getJobReservedl() {
        return jobReservedl;
    }

    public void setJobReservedl(String jobReservedl) {
        this.jobReservedl = jobReservedl;
    }
}
