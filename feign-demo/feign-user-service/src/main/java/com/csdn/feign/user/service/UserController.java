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

}
