package com.csdn.hystrix.client.controller;

import com.csdn.hystrix.client.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xwf
 * @date ：Created in 2020-8-21 10:52
 */
@RestController
public class HystrixController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hystrix/getUser")
    @HystrixCommand(commandKey = "getUser", groupKey = "user", fallbackMethod = "fallback", threadPoolKey = "tpk1",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100")})
    public User getUser(Long id) {
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("id", id);
        User user = restTemplate.getForObject("http://user-service/hystrix/getUser?id={id}", User.class, uriVariables);
        return user;
    }

    /**
     * 回退方法
     * 注意方法签名一致
     *
     * @param id
     * @return
     */
    public User fallback(Long id) {
        return new User(id, "默认");
    }
}
