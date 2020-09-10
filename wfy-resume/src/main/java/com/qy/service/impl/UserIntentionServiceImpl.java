package com.qy.service.impl;

import com.qy.dao.UserIntentionDao;
import com.qy.pojo.resume.Intention;
import com.qy.pojo.resume.UserIntention;
import com.qy.service.UserIntentionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserIntentionServiceImpl implements UserIntentionService {

    @Resource
    UserIntentionDao userIntentionDao;

    //查询所有的求职意向和用户的联合表
    @Override
    public List<Intention> findResumeByUserIntentionId(Integer userId) {
        return userIntentionDao.findResumeByUserIntentionId(userId);
    }

    //修改求职意向和用户的联合表
    @Override
    public Integer updateResumeByUserIntentionId(UserIntention userIntention) {
        return userIntentionDao.updateResumeByUserIntentionId(userIntention);
    }

    //添加新的求职意向和用户的联合表
    @Override
    public Integer saveResumeUserIntention(UserIntention userIntention) {
        return userIntentionDao.saveResumeUserIntention(userIntention);
    }

    //删除求职意向和用户的联合表
    @Override
    public Integer deleteResumeByUserIntentionId(Integer IntentionId) {
        return userIntentionDao.deleteResumeByUserIntentionId(IntentionId);
    }

}
