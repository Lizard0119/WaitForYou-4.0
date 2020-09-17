package com.qy.pojo.sendresume;

/**
 * @author Hz
 * 2020/9/11
 *
 *
 * 简历 职位 关联表
 */

public class UserAndJob {


    private int userid;
    private String username;
    private int userJobState;
    private String jobname;
    private String bossname;

    public int getUserId() {
        return userid;
    }

    public void setUserId(int userId) {
        this.userid = userId;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserJobState() {
        return userJobState;
    }

    public void setUserJobState(int userJobState) {
        this.userJobState = userJobState;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getBossname() {
        return bossname;
    }

    public void setBossname(String bossname) {
        this.bossname = bossname;
    }

    public UserAndJob() {
    }

    public UserAndJob(int userId, String username, int userJobState, String jobname, String bossname) {
        this.userid = userId;
        this.username = username;
        this.userJobState = userJobState;
        this.jobname = jobname;
        this.bossname = bossname;
    }
}
