package com.csdn.feign.client;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ：xwf
 * @date ：Created in 2020-8-20 9:56
 */
@SpringBootApplication(scanBasePackages="com.csdn")
@EnableDiscoveryClient
@EnableFeignClients(basePackages="com.csdn")
public class FeignClientBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(FeignClientBootstrap.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
