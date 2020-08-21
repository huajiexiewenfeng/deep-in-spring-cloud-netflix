package com.csdn.hystrix.client;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author ：xwf
 * @date ：Created in 2020-8-21 10:48
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
public class HystrixClientBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(HystrixClientBootstrap.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
