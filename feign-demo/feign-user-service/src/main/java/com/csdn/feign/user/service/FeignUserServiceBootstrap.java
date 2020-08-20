package com.csdn.feign.user.service;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ：xwf
 * @date ：Created in 2020-8-20 11:19
 */
@SpringBootApplication
@EnableDiscoveryClient
public class FeignUserServiceBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(FeignUserServiceBootstrap.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
