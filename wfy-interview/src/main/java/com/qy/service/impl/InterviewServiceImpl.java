package com.qy.service.impl;

import com.qy.dao.IInterviewDao;
import com.qy.pojo.interview.Interview;
import com.qy.pojo.interview.InterviewCompany;
import com.qy.pojo.interview.InterviewUser;
import com.qy.service.IInterviewCompanyService;
import com.qy.service.IInterviewService;
import com.qy.service.IInterviewUserService;
import com.qy.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

@Service
public class InterviewServiceImpl implements IInterviewService {

    @Resource
    private IInterviewDao interviewDao;

    @Autowired
    private IInterviewUserService interviewUserService;

    @Autowired
    private IInterviewCompanyService interviewCompanyService;

    @Override
    @Transactional
    public boolean saveInterview(Map map) {
        int currentUserId = Integer.parseInt(map.get("currentUserId").toString());
        int interviewUserId = Integer.parseInt(map.get("interviewUserId").toString());
        int companyId = 2;
        Date interviewDate = DateUtil.strToUtilDate(map.get("interviewDate").toString());
        String interviewSite = map.get("interviewSite").toString();
        String interviewContactName = map.get("interviewContactName").toString();
        String interviewTelephone = map.get("interviewTelephone").toString();
        Interview interview = new Interview();
        interview.setInterviewData(interviewDate);
        interview.setInterviewSite(interviewSite);
        interview.setInterviewContactName(interviewContactName);
        interview.setInterviewTelephone(interviewTelephone);
        if (interviewDao.saveInterview(interview) > 0) {
            Integer interviewId = interview.getInterviewId();
            InterviewUser interviewUser = new InterviewUser();
            interviewUser.setInterviewId(interviewId);
            interviewUser.setUserId(interviewUserId);
            if (interviewUserService.saveInterviewUser(interviewUser)) {
                InterviewCompany interviewCompany = new InterviewCompany();
                interviewCompany.setInterviewId(interviewId);
                interviewCompany.setCompanyId(companyId);
                if (interviewCompanyService.saveInterviewCompany(interviewCompany)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    @Transactional
    public boolean removeInterview(Map map) {
        int interviewUserId = Integer.parseInt(map.get("interviewUserId").toString());
        int interviewId = Integer.parseInt(map.get("interviewId").toString());
        int companyId = Integer.parseInt(map.get("companyId").toString());
        if (interviewDao.removeInterview(interviewId) > 0) {
            InterviewUser interviewUser = new InterviewUser();
            interviewUser.setUserId(interviewUserId);
            interviewUser.setInterviewId(interviewId);
            if (interviewUserService.removeInterviewUser(interviewUser)) {
                InterviewCompany interviewCompany = new InterviewCompany();
                interviewCompany.setInterviewId(interviewId);
                interviewCompany.setCompanyId(companyId);
                if (interviewCompanyService.removeInterviewCompany(interviewCompany)) {
                    return true;
                }
            }
        }
        return false;
    }
}
