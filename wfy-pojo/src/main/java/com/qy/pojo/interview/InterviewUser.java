package com.qy.pojo.interview;

import lombok.Data;

/**
 * 面试-用户关联表
 */
@Data
public class InterviewUser {
   // 面试ID
   private Integer interviewId;
   // 用户ID
    private Integer userId;
}
