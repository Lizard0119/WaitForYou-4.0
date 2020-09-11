package com.qy.service.impl;

import com.qy.service.EmailService;
import com.qy.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class EmailServiceImpl implements EmailService {

    @Value("${spring.mail.username}")
    private String sendName;

    @Resource
    JavaMailSender javaMailSender;

    @Resource
    RedisUtil redisUtil;

    @Override
    public String sendMail(String mail) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(sendName);
        simpleMailMessage.setTo(mail);
        simpleMailMessage.setSubject("麻豆注册提醒");
        simpleMailMessage.setText("");
        //生成4位随机数
        int i = Integer.parseInt(String.format("%04d", new Random().nextInt(9999)));
        simpleMailMessage.setText("小麻豆提醒您，此次验证码为：" + "\t" + i + "!\n" +"麻豆欢迎你的到来!");

        try {
            javaMailSender.send(simpleMailMessage);
            redisUtil.set(mail,i,30*60);
            return "发送成功";
        }catch (Exception e){
            e.printStackTrace();
            return "发送失败";
        }

    }
}
