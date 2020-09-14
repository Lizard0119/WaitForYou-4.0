package com.qy.service;

import com.qy.pojo.search.BaseResp;
import com.qy.pojo.search.JobFirst;
import com.qy.pojo.search.JobSecond;

public interface JobService {
    // job的第一分类CRUD
    BaseResp findAllJobFirst();

    JobFirst getJobFirstById(Integer jobTableFid);

    String deleteJobFirstById(Integer jobTableFid);

    String updateJobFirst(JobFirst jobFirst);

    String saveJobFirst(JobFirst jobFirst);

    // job的第二分类CRUD
    BaseResp findAllJobSecond(Integer page, Integer size);

    JobSecond getJobSecondById(Integer jobTableSid);

    String updateJobSecond(JobSecond jobSecond);

    String saveJobSecond(JobSecond jobSecond);

    String deleteJobSecondById(Integer jobTableSid);

    //两个分类联查,返回所查第一分类下的第二分类职务list
    BaseResp findByFirstAndSecondJob(Integer jobTableFid);
}
