package com.csdn.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：xwf
 * @date ：Created in 2020-8-17 18:58
 */
@RestController
public class RestTestController {

    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @GetMapping("/testRest")
    public String testRest() {
        String html = restTemplate.getForObject("http://www.baidu.com", String.class);
        return html;
    }
}
