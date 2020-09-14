package com.qy.listen;

import com.qy.utils.RedisUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Random;

@Component
public class SendMail {

    @Resource
    JavaMailSender javaMailSender;

    @Resource
    RedisUtil redisUtil;

    @Value("${spring.mail.username}")
    public String from;

    @RabbitListener(queues = "wfy-email",containerFactory="rabbitListenerContainerFactory")
    public void sendEmail(Map map){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        Object email = map.get("email");
        simpleMailMessage.setTo(email.toString());
        simpleMailMessage.setSubject("【麻豆服务】注册通知");
        simpleMailMessage.setText("");
        int i = Integer.parseInt(String.format("%04d", new Random().nextInt(9999)));
        simpleMailMessage.setText("小麻豆提醒您，此次验证码为：" + "\t" + i + "!" + "\n" +"麻豆欢迎你的到来!");
        try {
            javaMailSender.send(simpleMailMessage);
            redisUtil.set((String) email,i,30*60);
        }catch (MailException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
