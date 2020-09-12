package com.qy.service;

import com.qy.pojo.interview.InterviewUser;

public interface IInterviewUserService {
    boolean saveInterviewUser(InterviewUser interviewUser);

    boolean removeInterviewUser(InterviewUser interviewUser);
}
