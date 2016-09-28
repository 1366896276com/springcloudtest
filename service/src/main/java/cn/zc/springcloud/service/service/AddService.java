package cn.zc.springcloud.service.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

/**
 * Created by 张晨 on 2016/9/27.
 */
@RefreshScope
@Service
public class AddService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${from}")
    private String from;

    @HystrixCommand(fallbackMethod = "fallback")
    public int add(int a,int b){
        logger.info(from);


        if(a+b>3){
            throw new RuntimeException("hystrix test");
        }
        return a+b;
    }

    public int fallback(int a,int b){
        return -9999;
    }
}
