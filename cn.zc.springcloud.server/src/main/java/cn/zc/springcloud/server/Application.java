package cn.zc.springcloud.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * 具体参考博客  
 * http://blog.didispace.com/tag/spring-cloud/
 * @author 张晨
 *
 * 用于服务注册
 */
@EnableEurekaServer
@SpringBootApplication
public class Application {
	public static void main(String[] args) {

		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}
}
