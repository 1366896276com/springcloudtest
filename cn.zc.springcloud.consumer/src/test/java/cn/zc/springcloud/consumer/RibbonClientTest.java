package cn.zc.springcloud.consumer;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;
import com.netflix.appinfo.MyDataCenterInstanceConfig;
import com.netflix.client.ClientFactory;
import com.netflix.discovery.DefaultEurekaClientConfig;
import com.netflix.discovery.DiscoveryManager;
import com.netflix.loadbalancer.DynamicServerListLoadBalancer;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.Server;

public class RibbonClientTest {
	static final Logger logger = LoggerFactory.getLogger(DiscoveryManager.class);

	@Test
	public void testRibbon() {
		DiscoveryManager.getInstance().initComponent(new MyDataCenterInstanceConfig(), new DefaultEurekaClientConfig());
		ApplicationInfoManager.getInstance().setInstanceStatus(InstanceStatus.UP);

		// get LoadBalancer instance from configuration, properties file
		DynamicServerListLoadBalancer lb = (DynamicServerListLoadBalancer) ClientFactory
				.getNamedLoadBalancer("myclient");
		// use RandomRule 's RandomRule algorithm to get a random server from lb
		// 's server list
		RandomRule randomRule = new RandomRule();
		Server randomAlgorithmServer = randomRule.choose(lb, null);
		logger.debug("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		logger.debug("random algorithm server host:" + randomAlgorithmServer.getHost() + ";port:"
				+ randomAlgorithmServer.getPort());
		logger.debug("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		// Un register from eureka.
		DiscoveryManager.getInstance().shutdownComponent();
	}
}
