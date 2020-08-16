package com.csdn.eureka.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 手动更新应用状态
 *
 * @author ：xwf
 * @date ：Created in 2020\8\16 0016 16:37
 */
@RestController
public class StatusUpdateController {

    @Autowired
    private CustomHealthIndicator customHealthIndicator;

    @RequestMapping("/statusUpdate")
    public String statusUpdate(boolean status) {
        customHealthIndicator.setStatus(status);
        return "修改状态：" + status;
    }
}
