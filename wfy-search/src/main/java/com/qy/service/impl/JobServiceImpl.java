package com.qy.service.impl;

import com.qy.dao.JobDao;
import com.qy.pojo.search.BaseResp;
import com.qy.pojo.search.Company2Job;
import com.qy.pojo.search.JobFirst;
import com.qy.pojo.search.JobSecond;
import com.qy.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobDao jobDao;

    @Autowired
    RedisTemplate redisTemplate;

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
    public BaseResp findAllJobSecond(Integer page, Integer size) {
//        List<JobSecond> allJobSecond = jobDao.findAllJobSecond();
//        BaseResp baseResp = new BaseResp();
//
//        if (!allJobSecond.isEmpty()) {
//            baseResp.setList(allJobSecond);
//            baseResp.setCode(200);
//            baseResp.setMessage("查询成功");
//            baseResp.setTotal((long) allJobSecond.size());
//            return baseResp;
//        } else {
//            baseResp.setMessage("查询失败");
//            return baseResp;
//        }
        Boolean secondList = redisTemplate.hasKey("secondList");
        List secondList1 = new ArrayList();
        BaseResp baseResp = new BaseResp();
        Integer start = (page - 1) * size;
        Long total;
        if (secondList) {
            System.out.println("从redis中进行获取");
            secondList1 = redisTemplate.opsForList().range("secondList", start, start + size);
            total = redisTemplate.opsForList().size("secondList");

            baseResp.setList(secondList1);
            baseResp.setTotal(total);
            return baseResp;
        } else {
            System.out.println("从数据库查询数据");
            List<JobSecond> allJobSecond = jobDao.findAllJobSecond();
            for (JobSecond js : allJobSecond
            ) {
                redisTemplate.opsForList().rightPush("secondList", js);
            }
            secondList1 = redisTemplate.opsForList().range("secondList", start, start + size);
            total = redisTemplate.opsForList().size("secondList");
            //设置过期时间为30min
//            redisTemplate.expire("secondList",30, TimeUnit.MINUTES);
            baseResp.setList(secondList1);
            baseResp.setTotal(total);
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

    @Override
    public BaseResp findJopByCompanyId(Integer companyId) {
        List<Company2Job> jopByCompanyId = jobDao.findJopByCompanyId(companyId);
        BaseResp baseResp = new BaseResp();
        baseResp.setList(jopByCompanyId);
        baseResp.setCode(200);
        baseResp.setTotal((long) jopByCompanyId.size());
        baseResp.setMessage("本次通过公司查询职位");

        return baseResp;
    }


}
