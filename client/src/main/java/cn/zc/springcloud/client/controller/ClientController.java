package cn.zc.springcloud.client.controller;

import cn.zc.springcloud.client.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 张晨 on 2016/9/26.
 * 使用ribbon实现客户端调用，使用负载均衡
 */
@RestController
public class ClientController {
    @Autowired
    TestService testService;
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() throws Exception {
        return testService.addService();
    }
}
