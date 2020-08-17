package com.csdn.user.controller;

import com.csdn.user.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户
 *
 * @author ：xwf
 * @date ：Created in 2020-8-17 17:24
 */
@RestController
public class UserController {

    @Value("${server.port}")
    private String port;

    @GetMapping("getUser")
    public User getUser() {
        User user = new User();
        user.setId(1L);
        user.setName("小仙 port:" + port);
        return user;
    }

}
