package com.qy.controller;

import com.qy.pojo.search.BaseResp;
import com.qy.pojo.search.JobFirst;
import com.qy.pojo.search.JobSecond;
import com.qy.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    JobService jobService;

    //通过公司ID查职位
    @RequestMapping("/findJobByCompanyId/{companyId}")
    public BaseResp findJobByCompanyId(@PathVariable("companyId") Integer companyId) {
        return jobService.findJopByCompanyId(companyId);
    }

    //job第一分类查询所有
    @RequestMapping("/findAllFirstJob")
    public BaseResp findAllFirstJob() {
        return jobService.findAllJobFirst();
    }

    //job第一分类按id查
    @RequestMapping("/findJobFirstById/{jobTableFid}")
    public JobFirst findJobFirstById(@PathVariable("jobTableFid") Integer jobTableFid) {
        return jobService.getJobFirstById(jobTableFid);
    }

    //job第一分类按id删
    @RequestMapping("/deleteJobFirstById/{jobTableFid}")
    public String deleteJobFirstById(@PathVariable("jobTableFid") Integer jobTableFid) {
        return jobService.deleteJobFirstById(jobTableFid);
    }

    //job第一分类update
    @RequestMapping("/updateJobFirst")
    public String updateJobFirst(@RequestBody JobFirst jobFirst) {
        return jobService.updateJobFirst(jobFirst);
    }

    //job第一分类新增
    @RequestMapping("/saveJobFirst")
    public String saveJobFirst(@RequestBody JobFirst jobFirst) {
        return jobService.saveJobFirst(jobFirst);
    }

    //job第2分类查询所有
    @RequestMapping("/findAllSecondJob/{page}/{size}")
    public BaseResp findAllSecondJob(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return jobService.findAllJobSecond(page, size);
    }

    //job第2分类按id查
    @RequestMapping("/getJobSecondById/{jobTableSid}")
    public JobSecond getJobSecondById(@PathVariable("jobTableSid") Integer jobTableSid) {
        return jobService.getJobSecondById(jobTableSid);
    }

    //job第2分类按id删
    @RequestMapping("/deleteJobSecondById/{jobTableSid}")
    public String deleteJobSecondById(@PathVariable("jobTableSid") Integer jobTableSid) {
        return jobService.deleteJobSecondById(jobTableSid);
    }

    //job第2分类update
    @RequestMapping("/updateJobSecond")
    public String updateJobSecond(@RequestBody JobSecond jobSecond) {
        return jobService.updateJobSecond(jobSecond);
    }

    //job第2分类新增
    @RequestMapping("/saveJobSecond")
    public String saveJobSecond(@RequestBody JobSecond jobSecond) {
        return jobService.saveJobSecond(jobSecond);
    }

    //两个分类联查,返回所查第一分类下的第二分类职务list
    @RequestMapping("/findByFirstAndSecondJob/{jobTableFid}")
    public BaseResp findByFirstAndSecondJob(@PathVariable("jobTableFid") Integer jobTableFid) {
        return jobService.findByFirstAndSecondJob(jobTableFid);
    }

}
