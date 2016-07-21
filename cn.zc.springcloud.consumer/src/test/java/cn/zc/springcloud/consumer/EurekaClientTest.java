package cn.zc.springcloud.consumer;


import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.appinfo.MyDataCenterInstanceConfig;
import com.netflix.discovery.DefaultEurekaClientConfig;
import com.netflix.discovery.DiscoveryManager;

public class EurekaClientTest {
	static final Logger logger = LoggerFactory.getLogger(DiscoveryManager.class);

	
	
	/**
	 * git上的例子  https://github.com/Netflix/eureka/tree/v1.4.6/eureka-examples
	 */
	@Test
	public void testeureka() {

		// initialize the client
		DiscoveryManager.getInstance().initComponent(new MyDataCenterInstanceConfig(), new DefaultEurekaClientConfig());

		// this is the vip address for the example service to talk to as defined
		// in conf/sample-eureka-service.properties
		String vipAddress = "COMPUTE-SERVICE";

		List<InstanceInfo> list = DiscoveryManager.getInstance().getEurekaClient().getInstancesByVipAddress(vipAddress,
				false);

		for (InstanceInfo nextServerInfo : list) {
			logger.debug("nextServerInfo.getAppGroupName()-" + nextServerInfo.getAppGroupName());
			logger.debug("nextServerInfo.getAppName()-" + nextServerInfo.getAppName());
			logger.debug("nextServerInfo.getASGName()-" + nextServerInfo.getASGName());
			logger.debug("nextServerInfo.getHomePageUrl()-" + nextServerInfo.getHomePageUrl());
			logger.debug("nextServerInfo.getHostName()-" + nextServerInfo.getHostName());
			logger.debug("nextServerInfo.getId()-" + nextServerInfo.getId());
			logger.debug("nextServerInfo.getIPAddr()-" + nextServerInfo.getIPAddr());
			logger.debug("nextServerInfo.getLastUpdatedTimestamp()-" + nextServerInfo.getLastUpdatedTimestamp());
			logger.debug("nextServerInfo.getPort()-" + nextServerInfo.getPort());
			logger.debug("nextServerInfo.getSecureVipAddress()-" + nextServerInfo.getSecureVipAddress());
			logger.debug("nextServerInfo.getStatusPageUrl()-" + nextServerInfo.getStatusPageUrl());
			logger.debug("nextServerInfo.getVIPAddress()-" + nextServerInfo.getVIPAddress());
			logger.debug("nextServerInfo.getLastDirtyTimestamp()-" + nextServerInfo.getLastDirtyTimestamp());
			logger.debug("nextServerInfo.getHealthCheckUrls()-" + nextServerInfo.getHealthCheckUrls());
			logger.debug("nextServerInfo.getStatus()-" + nextServerInfo.getStatus());
		}

		// InstanceInfo nextServerInfo = null;
		// try {
		// nextServerInfo =
		// DiscoveryManager.getInstance().getEurekaClient().getNextServerFromEureka(vipAddress,
		// false);
		//
		//
		// } catch (Exception e) {
		// System.err.println("Cannot get an instance of example service to talk
		// to from eureka");
		// System.exit(-1);
		// }
		//
		// System.out.println("Found an instance of example service to talk to
		// from eureka: "
		// + nextServerInfo.getVIPAddress() + ":" + nextServerInfo.getPort());
		//
		// System.out.println("healthCheckUrl: " +
		// nextServerInfo.getHealthCheckUrl());
		// System.out.println("override: " +
		// nextServerInfo.getOverriddenStatus());

		// Socket s = new Socket();
		// int serverPort = nextServerInfo.getPort();
		// try {
		// s.connect(new InetSocketAddress(nextServerInfo.getHostName(),
		// serverPort));
		// } catch (IOException e) {
		// System.err.println("Could not connect to the server :"
		// + nextServerInfo.getHostName() + " at port " + serverPort);
		// } catch (Exception e) {
		// System.err.println("Could not connect to the server :"
		// + nextServerInfo.getHostName() + " at port " + serverPort + "due to
		// Exception " + e);
		// }
		// try {
		// String request = "FOO " + new Date();
		// System.out.println("Connected to server. Sending a sample request: "
		// + request);
		//
		// PrintStream out = new PrintStream(s.getOutputStream());
		// out.println(request);
		//
		// System.out.println("Waiting for server response..");
		// BufferedReader rd = new BufferedReader(new
		// InputStreamReader(s.getInputStream()));
		// String str = rd.readLine();
		// if (str != null) {
		// System.out.println("Received response from server: " + str);
		// System.out.println("Exiting the client. Demo over..");
		// }
		// rd.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		// finally shutdown
		DiscoveryManager.getInstance().getEurekaClient().shutdown();
	}



}
