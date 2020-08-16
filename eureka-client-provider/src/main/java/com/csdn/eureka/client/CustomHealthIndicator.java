package com.csdn.eureka.client;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * @author ：xwf
 * @date ：Created in 2020\8\16 0016 16:45
 */
@Component
public class CustomHealthIndicator extends AbstractHealthIndicator {

    private boolean status;

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void doHealthCheck(Health.Builder builder) throws Exception {
        if(status){
            builder.up();
        }else{
            builder.down();
        }
    }
}
