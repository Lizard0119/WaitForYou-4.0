package com.qy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Hz
 * 2020/9/10
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SendResumeApplication {
    public static void main(String[] args) {
        SpringApplication.run(SendResumeApplication.class);
    }
}
