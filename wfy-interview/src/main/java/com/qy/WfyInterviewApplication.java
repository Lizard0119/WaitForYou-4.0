package com.qy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WfyInterviewApplication {
    public static void main(String[] args) {
        SpringApplication.run(WfyInterviewApplication.class, args);
    }
}
