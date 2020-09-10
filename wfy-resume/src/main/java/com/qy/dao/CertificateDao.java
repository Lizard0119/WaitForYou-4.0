package com.qy.dao;

import com.qy.pojo.resume.Certificate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CertificateDao {


    //查询所有的资格证书
    List<Certificate> findResumeByCertificateId(Integer uesrId);
    //修改资格证书
    Integer updateResumeByCertificateId(Certificate certificate);
    //添加新的资格证书
    Integer saveResumeCertificate(Certificate certificate);
    //删除资格证书
    Integer deleteResumeByCertificateId(Integer certificateId);
}
