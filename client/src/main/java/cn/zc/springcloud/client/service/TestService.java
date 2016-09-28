package cn.zc.springcloud.client.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * Created by 张晨 on 2016/9/27.
 */
@Service
public class TestService {
    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService() throws Exception {
        Random r=new Random();
        String s=restTemplate.getForEntity("http://TEST-SERVICE/add?a=1&b="+ r.nextInt(4)+"", String.class).getBody();
        Integer i=Integer.parseInt(s);
        if(i==-9999){
            throw new  Exception("test");
        }
        return s;
    }
    public String addServiceFallback() {
        return "error";
    }
}
