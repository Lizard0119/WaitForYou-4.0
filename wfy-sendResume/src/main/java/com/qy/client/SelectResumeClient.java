package com.qy.client;

import com.qy.pojo.resume.Resume;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Hz
 * 2020/9/16
 */
@FeignClient("wfy-resume")
public interface SelectResumeClient {
    @RequestMapping("/resume/{userId}")
     Resume sff(@PathVariable("userId") Integer userId);
}
