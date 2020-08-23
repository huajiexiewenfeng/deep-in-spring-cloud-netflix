package com.csdn.feign.user.api.configuration;

import com.csdn.feign.user.api.decoder.FeignClientErrorDecoder;
import com.csdn.feign.user.api.interceptor.CustomRequestInterceptor;
import feign.Contract;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.ErrorDecoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：xwf
 * @date ：Created in 2020-8-20 19:15
 */
@Configuration
public class CustomFeignConfig {

    @Bean
    public Logger getLogger() {
        return new Slf4jLogger();
    }

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

    /**
     * 自定义 Contract
     * @return
     */
    @Bean
    public Contract feignContract() {
        // 使用 feign 默认注解
//        return new feign.Contract.Default();
        // 使用 springMvc 注解
        return new SpringMvcContract();
    }
    // feignDecoder,feignEncoder.....

//    @Bean
//    public ErrorDecoder errorDecoder(){
//        return new FeignClientErrorDecoder();
//    }
}
