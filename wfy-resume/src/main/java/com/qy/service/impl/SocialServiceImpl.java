package com.qy.service.impl;

import com.qy.dao.SocialDao;
import com.qy.pojo.resume.Social;
import com.qy.service.SocialService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SocialServiceImpl implements SocialService {

    @Resource
    SocialDao socialDao;

    //通过用户id查询社交主页
    @Override
    public List<Social> findResumeBySocialUserId(Integer userId) {
        return socialDao.findResumeBySocialUserId(userId);
    }

    //社交主页增加方法
    @Override
    public int saveResumeSocial(Social social) {
        return socialDao.saveResumeSocial(social);
    }

    //社交主页删除方法
    @Override
    public int deleteSocialById(Integer socialId) {
        return socialDao.deleteSocialById(socialId);
    }

    //通过社交主页id修改方法
    @Override
    public int updateSocial(Social social) {
        return socialDao.updateSocial(social);
    }
}
