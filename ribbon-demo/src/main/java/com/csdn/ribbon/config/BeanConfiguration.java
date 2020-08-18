package com.csdn.ribbon.config;

import com.csdn.ribbon.rule.MyRule;
import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;

public class BeanConfiguration {

	@Bean
	public IRule myRule() {
		return new MyRule();
	}
	
}
