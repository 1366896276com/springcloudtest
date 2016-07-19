package cn.zc.springcloud.consumer.controller.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController2 {

	@Autowired
    ComputeClient computeClient;

    @RequestMapping(value = "/add2", method = RequestMethod.GET)
    public Integer add() {
        return computeClient.add(10, 20);
    }
}
