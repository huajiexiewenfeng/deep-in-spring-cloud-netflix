package com.csdn.feign.user.api.configuration;

import com.csdn.feign.user.api.interceptor.CustomRequestInterceptor;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：xwf
 * @date ：Created in 2020-8-20 19:15
 */
@Configuration
public class CustomFeignConfig {

    @Bean
    public Logger.Level getLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "password");
    }

    @Bean
    public CustomRequestInterceptor customRequestInterceptor() {
        return new CustomRequestInterceptor();
    }

    // Contract,feignDecoder,feignEncoder.....
}
