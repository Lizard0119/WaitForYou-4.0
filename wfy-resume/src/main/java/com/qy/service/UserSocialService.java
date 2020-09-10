package com.qy.service;

import com.qy.pojo.resume.UserSocial;

import java.util.List;

public interface UserSocialService {
    //通过用户id查寻社交主页关联表
    List<UserSocial> findResumeByUserUserSocialUserId(Integer userId);

    //增加方法,添加用户id和社交主页id
    int saveUserUserSocial(UserSocial userSocial);

    //通过社交主页id单条删除方法
    int deleteUserUserSocialById(Integer userSocialId);
    //修改方法
    int updateUserSocial(UserSocial userSocial);
}
