package com.csdn.feign.user.api.service;

import com.csdn.feign.user.api.configuration.CustomFeignConfig;
import com.csdn.feign.user.api.entity.User;
import com.csdn.feign.user.api.fallback.UserServiceFeignFallback;
//import com.csdn.feign.user.api.fallback.UserServiceFeignFallbackFactory;
import feign.QueryMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ：xwf
 * @date ：Created in 2020-8-20 11:03
 */
@FeignClient(value = "feign-user-service",
        fallback = UserServiceFeignFallback.class,
//        fallbackFactory = UserServiceFeignFallbackFactory.class,
        configuration = CustomFeignConfig.class)
public interface UserServiceFeignApi {

    @GetMapping("/api/feign/getUser")
    User getUser(@RequestParam("id") Long id);

    @GetMapping("/api/feign/getException")
    User getException(@RequestParam("id") Long id) throws Exception;

    @PostMapping("/api/feign/addUser")
    String addUser(@SpringQueryMap User user);
}
