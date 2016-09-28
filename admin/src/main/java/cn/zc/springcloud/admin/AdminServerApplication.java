package cn.zc.springcloud.admin;


import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by 张晨 on 2016/9/28.
 */
@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
public class AdminServerApplication {
    public static void main(String[] args){
        SpringApplication.run(AdminServerApplication.class,args);
    }
}
