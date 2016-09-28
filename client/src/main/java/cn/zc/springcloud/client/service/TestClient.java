package cn.zc.springcloud.client.service;

import cn.zc.springcloud.client.hystrix.TestClientHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 张晨 on 2016/9/26.
 */
@FeignClient(value = "test-service", fallback = TestClientHystrix.class)
public interface TestClient {

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

}


