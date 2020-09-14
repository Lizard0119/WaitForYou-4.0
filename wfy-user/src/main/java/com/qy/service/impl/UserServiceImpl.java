package com.qy.service.impl;

import com.qy.dao.IUserDao;
import com.qy.pojo.user.User;
import com.qy.pojo.user.UserReq;
import com.qy.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    IUserDao userDao;

    @Resource
    RedisTemplate redisTemplate;

    @Override
    public String login(User user) {

        User byUsername = userDao.findByUsername(user.getUsername());

        if (byUsername == null){
            return "没有该用户";
        }else if (! byUsername.getPassword().equals(user.getPassword())){
            return "密码错误";
        }

        String token = UUID.randomUUID().toString();
        //以token为key，查询出的用户对象为value存储到redis中
        redisTemplate.opsForValue().set(token,byUsername);
        //设置redis中数据失效的时间
        redisTemplate.expire(token,30, TimeUnit.MINUTES);

        return token;
    }

    @Override
    public String register(UserReq userReq) {

        //通过LoginName获取在Redis中的验证码
        String userEmail = userReq.getUserEmail();
        System.out.println(userEmail);
        String o = redisTemplate.opsForValue().get(userEmail).toString();
        if (o != null){
            if (o.toString().equals(userReq.getCode())){
                //验证码比对通过，添加到数据库，用户注册成功
                User user = new User();
//                user.setUserEmail(userEmail);
//                user.setPassword(userReq.getPassword());
//                user.setUsername(userReq.getUsername());
                BeanUtils.copyProperties(userReq,user);
                userDao.Register(user);
                return "注册成功";
            }else {
                return "验证码错误";
            }
        }
        return "验证码超时";
    }

}
