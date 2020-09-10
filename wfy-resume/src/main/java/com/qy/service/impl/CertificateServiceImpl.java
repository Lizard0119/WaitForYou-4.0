package com.qy.service.impl;

import com.qy.dao.CertificateDao;
import com.qy.pojo.resume.Certificate;
import com.qy.service.CertificateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService {

    @Resource
    CertificateDao certificateDao;

    //查询所有的资格证书
    @Override
    public List<Certificate> findResumeByCertificateId(Integer uesrId) {
        return certificateDao.findResumeByCertificateId(uesrId);
    }

    //修改资格证书
    @Override
    public Integer updateResumeByCertificateId(Certificate certificate) {
        return certificateDao.updateResumeByCertificateId(certificate);
    }

    //添加新的资格证书
    @Override
    public Integer saveResumeCertificate(Certificate certificate) {
        return certificateDao.saveResumeCertificate(certificate);
    }

    //删除资格证书
    @Override
    public Integer deleteResumeByCertificateId(Integer certificateId) {
        return certificateDao.deleteResumeByCertificateId(certificateId);
    }



}
