package com.qy.service;

import com.qy.pojo.resume.Certificate;

import java.util.List;


public interface CertificateService {


    //查询所有的资格证书
    List<Certificate> findResumeByCertificateId(Integer uesrId);
    //修改资格证书
    Integer updateResumeByCertificateId(Certificate certificate);
    //添加新的资格证书
    Integer saveResumeCertificate(Certificate certificate);
    //删除资格证书
    Integer deleteResumeByCertificateId(Integer certificateId);
}
