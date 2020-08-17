package com.csdn.ribbon.controller;

import com.csdn.ribbon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：xwf
 * @date ：Created in 2020-8-17 17:14
 */
@RestController
public class RibbonController {

    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("loadBalancedRestTemplate")
    private RestTemplate loadBalancedRestTemplate;

    @GetMapping("/getUser")
    public User getUser() {
        User user = restTemplate.getForObject("http://localhost:8181/getUser", User.class);
        return user;
    }

    @GetMapping("/ribbon/getUser")
    public User getUserRibbon() {
        User user = loadBalancedRestTemplate.getForObject("http://user-service/getUser", User.class);
        return user;
    }

}
