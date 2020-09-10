package com.qy.service;

import com.qy.pojo.resume.Intention;
import com.qy.pojo.resume.UserCertificate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserCertificateService {


    //查询所有的用户和资格证书的关联表
    List<Intention> findResumeByUserCertificateId(Integer userId);
    //修改用户和资格证书的关联表
    Integer updateResumeByUserCertificateId(UserCertificate userCertificate);
    //添加新的用户和资格证书的关联表
    Integer saveResumeUserCertificate(UserCertificate userCertificate);
    //删除用户和资格证书的关联表
    Integer deleteResumeByUserCertificateId(Integer CertificateId);
}
