package com.csdn.feign.user.api.fallback;

import com.csdn.feign.user.api.entity.User;
import com.csdn.feign.user.api.service.UserServiceFeignApi;
import org.springframework.stereotype.Component;

/**
 * @author ：xwf
 * @date ：Created in 2020-8-20 16:08
 */
@Component
public class UserServiceFeignFallback implements UserServiceFeignApi {
    @Override
    public User getUser(Long id) {
        return new User(id, "fallback");
    }
}
