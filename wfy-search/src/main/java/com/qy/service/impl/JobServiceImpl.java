package com.qy.service.impl;

import com.qy.dao.JobDao;
import com.qy.pojo.BaseResp;
import com.qy.pojo.JobFirst;
import com.qy.pojo.JobSecond;
import com.qy.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobDao jobDao;


    @Override
    public BaseResp findAllJobFirst() {
        List<JobFirst> allJobFirst = jobDao.findAllJobFirst();
        BaseResp baseResp = new BaseResp();
        if (!allJobFirst.isEmpty()) {
            baseResp.setList(allJobFirst);
            baseResp.setCode(200);
            baseResp.setMessage("查询成功");
            baseResp.setTotal((long) allJobFirst.size());
            return baseResp;
        } else {
            baseResp.setMessage("查询失败");
            return baseResp;
        }
    }

    @Override
    public JobFirst getJobFirstById(Integer jobTableFid) {
        JobFirst jobFirstById = jobDao.getJobFirstById(jobTableFid);
        if (jobFirstById != null) {
            return jobFirstById;
        }
        return null;
    }

    @Override
    public String deleteJobFirstById(Integer jobTableFid) {
        boolean b = jobDao.deleteJobFirstById(jobTableFid);
        if (b) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @Override
    public String updateJobFirst(JobFirst jobFirst) {
        boolean b = jobDao.updateJobFirst(jobFirst);
        if (b) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    @Override
    public String saveJobFirst(JobFirst jobFirst) {
        boolean b = jobDao.saveJobFirst(jobFirst);
        if (b) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }

    @Override
    public BaseResp findAllJobSecond() {
        List<JobSecond> allJobSecond = jobDao.findAllJobSecond();
        BaseResp baseResp = new BaseResp();

        if (!allJobSecond.isEmpty()) {
            baseResp.setList(allJobSecond);
            baseResp.setCode(200);
            baseResp.setMessage("查询成功");
            baseResp.setTotal((long) allJobSecond.size());
            return baseResp;
        } else {
            baseResp.setMessage("查询失败");
            return baseResp;
        }

    }

    @Override
    public JobSecond getJobSecondById(Integer jobTableSid) {
        JobSecond jobSecondById = jobDao.getJobSecondById(jobTableSid);
        if (jobSecondById != null) {
            return jobSecondById;
        } else {
            return null;
        }
    }

    @Override
    public String updateJobSecond(JobSecond jobSecond) {
        boolean b = jobDao.updateJobSecond(jobSecond);
        if (b) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    @Override
    public String saveJobSecond(JobSecond jobSecond) {
        boolean b = jobDao.saveJobSecond(jobSecond);
        if (b) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }

    @Override
    public String deleteJobSecondById(Integer jobTableSid) {
        boolean b = jobDao.deleteJobSecondById(jobTableSid);
        if (b) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @Override
    public BaseResp findByFirstAndSecondJob(Integer jobTableFid) {
        List<JobSecond> byFirstAndSecondJob = jobDao.findByFirstAndSecondJob(jobTableFid);
        BaseResp baseResp = new BaseResp();

        if (!byFirstAndSecondJob.isEmpty()) {
            baseResp.setList(byFirstAndSecondJob);
            baseResp.setCode(200);
            baseResp.setMessage("查询SecondJob成功");
            baseResp.setTotal((long) byFirstAndSecondJob.size());
            return baseResp;
        } else {
            baseResp.setMessage("查询SecondJob失败");
            return baseResp;
        }
    }


}
