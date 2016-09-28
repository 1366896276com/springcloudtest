package cn.zc.springcloud.client.hystrix;

import cn.zc.springcloud.client.service.TestClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by 张晨 on 2016/9/27.
 */
@Component
public class TestClientHystrix implements TestClient {
    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -9999;
    }
}
