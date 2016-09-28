package cn.zc.springcloud.client.controller;

import cn.zc.springcloud.client.service.TestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 张晨 on 2016/9/26.
 */
@RestController
@RequestMapping("/f")
public class FClientController {
    @Autowired
    TestClient testClient;
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer add() {
        return testClient.add(10, 20);
    }
}
