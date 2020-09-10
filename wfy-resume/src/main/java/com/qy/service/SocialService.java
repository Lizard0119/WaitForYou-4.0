package com.qy.service;

import com.qy.pojo.resume.Social;

import java.util.List;

public interface SocialService {


    //通过用户id查询社交主页
    List<Social> findResumeBySocialUserId(Integer userId);

    //社交主页增加方法
    int saveResumeSocial(Social social);
    //社交主页删除方法
    int deleteSocialById(Integer socialId);
    //通过社交主页id修改方法
    int updateSocial(Social social);
}
