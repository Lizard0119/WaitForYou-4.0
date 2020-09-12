package com.qy;

import com.qy.dao.IInterviewDao;
import com.qy.pojo.interview.Interview;
import com.qy.service.IInterviewService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestInterviewDao {

    @Resource
    private IInterviewDao interviewDao;

    @Resource
    private IInterviewService interviewService;
    @Test
    public void testInsertInterview() {
        Interview interview = new Interview();
        interview.setInterviewData(new Date());
        interview.setInterviewSite("新加披");
        interview.setInterviewContactName("张三");
        interview.setInterviewTelephone("13319187763");
        Integer integer = interviewDao.saveInterview(interview);
        System.out.println("=========================>" + interview.getInterviewId());
        System.out.println("=========================>" + integer);
    }

    @Test
    public void test1() {
        Interview interview = new Interview();
        interview.setInterviewData(new Date());
        interview.setInterviewSite("新西兰");
        interview.setInterviewContactName("李四");
        interview.setInterviewTelephone("13319187763");
        Map map = new HashMap<>();
        map.put("currentUserId", 1);
        map.put("interviewUserId", 2);
        map.put("interview", interview);
        boolean b = interviewService.saveInterview(map);
        System.out.println(b);
    }
}
