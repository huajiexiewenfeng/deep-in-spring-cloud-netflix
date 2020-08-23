package com.csdn.feign.user.api.fallback;

import com.csdn.feign.user.api.entity.User;
import com.csdn.feign.user.api.service.UserServiceFeignApi;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author ：xwf
 * @date ：Created in 2020-8-20 16:08
 */
@Component
public class UserServiceFeignFallbackFactory implements FallbackFactory<UserServiceFeignApi> {

    @Override
    public UserServiceFeignApi create(Throwable cause) {
        return new UserServiceFeignApi() {
            @Override
            public User getUser(Long id) {
                return null;
            }

            @Override
            public User getException(Long id) throws Exception {
                return null;
            }

            @Override
            public String addUser(User user) {
                return null;
            }
        };
    }
}
