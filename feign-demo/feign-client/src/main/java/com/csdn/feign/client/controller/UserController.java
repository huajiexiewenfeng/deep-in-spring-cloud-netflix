package com.csdn.feign.client.controller;

import com.csdn.feign.user.api.entity.User;
import com.csdn.feign.user.api.service.UserServiceFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：xwf
 * @date ：Created in 2020-8-20 11:08
 */
@RestController
public class UserController {

    @Autowired
    private UserServiceFeignApi userServiceFeignApi;

    @GetMapping("/feign/getUser")
    public User getUser(Long id) {
        User user = userServiceFeignApi.getUser(id);
        return user;
    }

    @GetMapping("/feign/getException")
    public User getException(Long id) throws Exception {
        User user = userServiceFeignApi.getException(id);
        return user;
    }

    @GetMapping("/feign/addUser")
    public String addUser() {
        User user = new User(1L,"xwf");
        return userServiceFeignApi.addUser(user);
    }
}
