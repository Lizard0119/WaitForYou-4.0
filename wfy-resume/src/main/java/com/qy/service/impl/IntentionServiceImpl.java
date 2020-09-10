package com.qy.service.impl;


import com.qy.dao.IntentionDao;
import com.qy.pojo.resume.Intention;
import com.qy.service.IntentionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class IntentionServiceImpl implements IntentionService {

    @Resource
    IntentionDao intentionDao;

    //查询所有的求职意向
    @Override
    public List<Intention> findResumeByIntentionId(Integer uesrId) {
        return intentionDao.findResumeByIntentionId(uesrId);
    }

    //修改求职意向
    @Override
    public Integer updateResumeByIntentionId(Intention intention) {
        return intentionDao.updateResumeByIntentionId(intention);
    }

    //添加新的求职意向
    @Override
    public Integer saveResumeIntention(Intention intention) {
        return intentionDao.saveResumeIntention(intention);
    }

    //删除求职意向
    @Override
    public Integer deleteResumeByIntentionId(Integer intentionId) {
        return intentionDao.deleteResumeByIntentionId(intentionId);
    }


}
