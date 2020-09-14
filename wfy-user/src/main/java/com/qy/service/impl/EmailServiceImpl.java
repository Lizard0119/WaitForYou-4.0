package com.qy.service.impl;

import com.qy.dao.IUserDao;
import com.qy.pojo.user.User;
import com.qy.service.EmailService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailServiceImpl implements EmailService {

    @Resource
    IUserDao userDao;

    @Resource
    RabbitTemplate rabbitTemplate;

    @Override
    public String sendMail(String email) {

        //去数据库检验，是否唯一
        User byUsername = userDao.findByUsername(email);

        if (byUsername != null){
            return "用户邮箱已注册";
        }
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setFrom(sendName);
//        simpleMailMessage.setTo(mail);
//        simpleMailMessage.setSubject("麻豆注册提醒");
//        simpleMailMessage.setText("");
//        //生成4位随机数
//        int i = Integer.parseInt(String.format("%04d", new Random().nextInt(9999)));
//        simpleMailMessage.setText("小麻豆提醒您，此次验证码为：" + "\t" + i + "!\n" +"麻豆欢迎你的到来!");

//            javaMailSender.send(simpleMailMessage);
//            redisUtil.set(mail,i,30*60);
            Map map = new HashMap<>();
            map.put("email",email);
            rabbitTemplate.convertAndSend("wfy-email",map);
            return "发送成功";
    }
}
