package com.qy.dao;

import com.qy.pojo.search.Company2Job;
import com.qy.pojo.search.JobFirst;
import com.qy.pojo.search.JobSecond;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobDao {

    // job的第一分类CRUD
    List<JobFirst> findAllJobFirst();

    JobFirst getJobFirstById(Integer jobTableFid);

    boolean updateJobFirst(JobFirst jobFirst);

    boolean saveJobFirst(JobFirst jobFirst);

    boolean deleteJobFirstById(Integer jobTableFid);

    // job的第二分类CRUD
    List<JobSecond> findAllJobSecond();

    JobSecond getJobSecondById(Integer jobTableSid);

    boolean updateJobSecond(JobSecond jobSecond);

    boolean saveJobSecond(JobSecond jobSecond);

    boolean deleteJobSecondById(Integer jobTableSid);

    //两个分类联查,返回所查第一分类下的第二分类职务list
    List<JobSecond> findByFirstAndSecondJob(Integer jobTableFid);

    //通过公司查职位
    List<Company2Job> findJopByCompanyId(Integer companyId);
}
