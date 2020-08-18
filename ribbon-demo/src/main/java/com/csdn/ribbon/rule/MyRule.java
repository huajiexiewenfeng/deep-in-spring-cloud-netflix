package com.csdn.ribbon.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

/**
 * 自定义负载均衡策略(随机)
 *
 * @author ：xwf
 * @date ：Created in 2020-8-18 15:12
 */
public class MyRule extends AbstractLoadBalancerRule {

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        String clientName = clientConfig.getClientName();
        System.out.println(clientName);
    }

    @Override
    public Server choose(Object key) {
        ILoadBalancer loadBalancer = getLoadBalancer();
        List<Server> allServers = loadBalancer.getAllServers();
        return allServers.get(new Random().nextInt(allServers.size()));
    }

}
