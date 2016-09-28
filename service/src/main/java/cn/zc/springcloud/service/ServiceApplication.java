package cn.zc.springcloud.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 张晨 on 2016/9/26.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrix
@EnableHystrixDashboard
public class ServiceApplication {


    public static void main(String[] args) {
        new SpringApplicationBuilder(ServiceApplication.class).web(true).run(args);

    }
}
