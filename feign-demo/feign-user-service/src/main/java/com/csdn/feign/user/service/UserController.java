package com.csdn.feign.user.service;

import com.csdn.feign.user.api.entity.User;
import com.csdn.feign.user.api.service.UserServiceFeignApi;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：xwf
 * @date ：Created in 2020-8-20 11:12
 */
@RestController
public class UserController implements UserServiceFeignApi {

    @Override
    public User getUser(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("小仙");
        return user;
    }

    @Override
    public User getException(Long id) throws Exception {
        throw new Exception("故意抛出异常");
    }

    @Override
    public String addUser(User user) {
        System.out.println("feign ObjectParam : "+user);
        return null;
    }

}
