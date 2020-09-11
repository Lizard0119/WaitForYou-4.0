package com.qy.service.impl;

import com.qy.dao.IUserDao;
import com.qy.pojo.user.User;
import com.qy.service.IUserService;
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

        UUID token = UUID.randomUUID();
        //以token为key，查询出的用户对象为value存储到redis中
        redisTemplate.opsForValue().set(token.toString(),byUsername);
        redisTemplate.expire(token.toString(),30, TimeUnit.MINUTES);

        return token.toString();
    }

//    @Override
//    public String Register(User user) {
//
//        User byUsernameAndEmail = userDao.findByUsernameAndEmail(user);
//
//        if (byUsernameAndEmail.getUsername().equals(user.getUsername())){
//            return "用户名已存在";
//        }else if (byUsernameAndEmail.getUserEmail().equals(user.getUserEmail())){
//            return "邮箱已被注册";
//        }
//
//        return "注册成功";
//    }


    public String getToken(Cookie[] cookies){
        if (cookies != null){
            for (Cookie cook:cookies
            ) {
                if (cook.getName().equals("token")){
                    String token = cook.getValue();
                    return token;
                }
            }
            return null;
        }
        return null;
    }
}
