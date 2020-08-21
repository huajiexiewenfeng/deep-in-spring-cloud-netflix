package com.csdn.user.controller;

import com.csdn.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * 用户
 *
 * @author ：xwf
 * @date ：Created in 2020-8-17 17:24
 */
@RestController
public class UserController {

    @Autowired
    private Environment environment;

    private final static Random random = new Random();

    @Value("${server.port}")
    private String port;

    @GetMapping("getUser")
    public User getUser() {
        User user = new User();
        user.setId(1L);
        user.setName("小仙 port:" + port);
        return user;
    }

    @GetMapping("/hystrix/getUser")
    public User getHystrixUser(Long id) throws InterruptedException {
        await();
        User user = new User();
        user.setId(id);
        user.setName("小仙 port:" + port);
        return user;
    }

    private void await() throws InterruptedException {
        int value = random.nextInt(200);
        System.out.println("port:" + getPort() + " cost " + value + "ms");
        Thread.sleep(value);
    }

    /**
     * 随机端口模式下通过 @Value 无法获取端口号，可以使用 Environment 这种方式获取
     *
     * @return
     */
    public String getPort() {
        return environment.getProperty("local.server.port");
    }
}
