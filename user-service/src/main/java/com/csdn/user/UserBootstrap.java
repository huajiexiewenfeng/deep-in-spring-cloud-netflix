package com.csdn.user;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author ：xwf
 * @date ：Created in 2020-8-17 17:22
 */
@SpringBootApplication
public class UserBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(UserBootstrap.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
