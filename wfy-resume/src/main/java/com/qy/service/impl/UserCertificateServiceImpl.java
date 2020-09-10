package com.qy.service.impl;

import com.qy.dao.UserCertificateDao;
import com.qy.pojo.resume.Intention;
import com.qy.pojo.resume.UserCertificate;
import com.qy.service.UserCertificateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserCertificateServiceImpl implements UserCertificateService {

    @Resource
    UserCertificateDao userCertificateDao;

    //查询所有的用户和资格证书的关联表
    @Override
    public List<Intention> findResumeByUserCertificateId(Integer userId) {
        return userCertificateDao.findResumeByUserCertificateId(userId);
    }

    //修改用户和资格证书的关联表
    @Override
    public Integer updateResumeByUserCertificateId(UserCertificate userCertificate) {
        return userCertificateDao.updateResumeByUserCertificateId(userCertificate);
    }

    //添加新的用户和资格证书的关联表
    @Override
    public Integer saveResumeUserCertificate(UserCertificate userCertificate) {
        return userCertificateDao.saveResumeUserCertificate(userCertificate);
    }

    //删除用户和资格证书的关联表
    @Override
    public Integer deleteResumeByUserCertificateId(Integer CertificateId) {
        return userCertificateDao.deleteResumeByUserCertificateId(CertificateId);
    }


}
