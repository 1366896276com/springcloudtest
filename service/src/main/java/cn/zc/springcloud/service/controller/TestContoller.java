package cn.zc.springcloud.service.controller;

import cn.zc.springcloud.service.service.AddService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 张晨 on 2016/9/26.
 */
@RestController
public class TestContoller {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private AddService addService;
    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {

        Integer r = addService.add(a,b);
        logger.info("/add, result:" + r);
        return r;
    }
}
