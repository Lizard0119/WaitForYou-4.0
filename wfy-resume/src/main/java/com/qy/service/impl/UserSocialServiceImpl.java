package com.qy.service.impl;

import com.qy.dao.UserSocialDao;
import com.qy.pojo.resume.UserSocial;
import com.qy.service.UserSocialService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserSocialServiceImpl implements UserSocialService {

    @Resource
    UserSocialDao userSocialDao;

    //通过用户id查寻社交主页关联表
    @Override
    public List<UserSocial> findResumeByUserUserSocialUserId(Integer userId) {
        return userSocialDao.findResumeByUserUserSocialUserId(userId);
    }

    //增加方法,添加用户id和社交主页id
    @Override
    public int saveUserUserSocial(UserSocial userSocial) {
        return userSocialDao.saveUserUserSocial(userSocial);
    }

    //通过社交主页id单条删除方法
    @Override
    public int deleteUserUserSocialById(Integer userSocialId) {
        return userSocialDao.deleteUserUserSocialById(userSocialId);
    }

    //修改方法
    @Override
    public int updateUserSocial(UserSocial userSocial) {
        return userSocialDao.updateUserSocial(userSocial);
    }
}
