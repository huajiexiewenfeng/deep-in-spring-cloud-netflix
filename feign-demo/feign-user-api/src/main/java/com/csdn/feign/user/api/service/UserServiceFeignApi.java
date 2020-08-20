package com.csdn.feign.user.api.service;

import com.csdn.feign.user.api.entity.User;
import com.csdn.feign.user.api.fallback.UserServiceFeignFallback;
import com.csdn.feign.user.api.fallback.UserServiceFeignFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ：xwf
 * @date ：Created in 2020-8-20 11:03
 */
@FeignClient(value = "feign-user-service",
//        fallback = UserServiceFeignFallback.class,
        fallbackFactory = UserServiceFeignFallbackFactory.class)
public interface UserServiceFeignApi {

    @GetMapping("/api/feign/getUser")
    User getUser(@RequestParam("id") Long id);

}
