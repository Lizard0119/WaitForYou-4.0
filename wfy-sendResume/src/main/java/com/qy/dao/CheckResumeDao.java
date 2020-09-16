package com.qy.dao;

import com.qy.pojo.sendresume.UserAndJob;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Hz
 * 2020/9/15
 */
@Mapper
public interface CheckResumeDao {
    //查 招聘信息 下 的所有简历
    List<UserAndJob> selectResumeByJob(@Param("jobid") int jobid);
    //删除简历
    int deleteResumeByUserId(@Param("userid")int userid);
}
