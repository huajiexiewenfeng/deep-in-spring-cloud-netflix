package com.csdn.ribbon.api;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.reactive.LoadBalancerCommand;
import rx.Observable;

import java.util.Arrays;
import java.util.List;

/**
 * 原生 Ribbon API 示例
 *
 * @author ：xwf
 * @date ：Created in 2020-8-17 15:34
 */
public class RibbonNativeClientDemo {
    public static void main(String[] args) {
        // 服务实例列表
        List<Server> serverList = Arrays.asList(new Server("localhost", 8081),
                new Server("localhost", 8083),
                new Server("localhost", 8084),
                new Server("localhost", 8085));
        // 构建 LoadBalancer
        BaseLoadBalancer baseLoadBalancer = LoadBalancerBuilder.newBuilder().buildFixedServerListLoadBalancer(serverList);
        // 设置负债均衡策略
        baseLoadBalancer.setRule(new RandomRule());// 随机
        // 测试
        for (int i = 0; i < 10; i++) {
            test(baseLoadBalancer);
        }
    }

    private static void test(BaseLoadBalancer baseLoadBalancer) {
        String result = LoadBalancerCommand.<String>builder().withLoadBalancer(baseLoadBalancer).build()
                .submit(server -> {
                    try {
                        String addr = "http://" + server.getHost() + ":" + server.getPort();
                        System.out.println("调用地址：" + addr);
                        return Observable.just("success");
                    } catch (Exception e) {
                        return Observable.error(e);
                    }
                }).toBlocking().first();
        System.out.println("调用结果：" + result);
    }
}
