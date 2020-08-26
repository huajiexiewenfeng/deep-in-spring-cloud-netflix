package com.csdn.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/**
 * @author ：xwf
 * @date ：Created in 2020-8-25 20:23
 */
@SpringBootApplication
//@EnableZuulServer 一般不会使用，功能较弱
@EnableZuulProxy
public class ZuulServer {
    public static void main(String[] args) {
        SpringApplication.run(ZuulServer.class, args);
    }
}
