package com.csdn.eureka.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 服务注册-客户端
 *
 * @author ：xwf
 * @date ：Created in 2020-8-15 11:28
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class EurekaClientProviderServer {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hello")
    public String hello(String name) {
        return "[端口：" + port + "]-hello:" + name;
    }

    /**
     * 从注册中心获取服务器列表信息
     *
     * @param serviceId
     * @return
     */
    @RequestMapping("/getInstances")
    public List<ServiceInstance> getInstances(String serviceId) {
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
        return instances;
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaClientProviderServer.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
