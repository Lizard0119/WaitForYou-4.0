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
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    IUserDao userDao;

    @Resource
    RedisTemplate redisTemplate;

    @Override
    public Map login(User user) {

        User byUsername = userDao.findByUsername(user.getUsername());

        Map<String, Object> map = new HashMap<>();

        if (byUsername == null){
            map.put("message","没有该用户");
            return map;
        }else if (! byUsername.getPassword().equals(user.getPassword())){
            map.put("message","密码错误");
            return map;
        }
        map.put("message","登陆成功");
        String token = UUID.randomUUID().toString();
        map.put("token",token);
        //以token为key，查询出的用户对象为value存储到redis中
        redisTemplate.opsForValue().set(token,byUsername);
        //设置redis中数据失效的时间
        redisTemplate.expire(token,30, TimeUnit.MINUTES);
        map.put("User",byUsername);
        System.out.println(map);
        return map;
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

    @Override
    public User getUserById(int userid) {

        System.out.println(userDao.getUserById(userid));
        return userDao.getUserById(userid);
    }

    @Override
    public String updateUser(User user) {
        if (userDao.updateUser(user)>0){
            return "修改成功";
        }else{
            return "修改失败";
        }

    }

}
