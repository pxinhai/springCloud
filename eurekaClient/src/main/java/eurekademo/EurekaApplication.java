package eurekademo;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;

import ch.qos.logback.core.joran.action.Action;

/**
 *
 * @author Gunnar Hillert
 *
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
// @EnableAutoConfiguration
public class EurekaApplication {

	@Autowired
	DiscoveryClient client;
	
	 @Autowired  
	 RestTemplate restTemplate;  
	 
	@RequestMapping("/hello")
	public String home() {
		return this.client.getLocalServiceInstance().getServiceId();
	}
	
	@RequestMapping("/test")
	public String test(){
		return this.restTemplate.getForEntity("http://eurekaClient1/hello", String.class).getBody();
	}

	public static void main(String[] args) throws Exception {
		// System.err.println(new
		// ClassPathResource("static/eureka/css/wro.css").getURL());
		SpringApplication.run(EurekaApplication.class, args);
		// new
		// SpringApplicationBuilder(EurekaApplication.class).web(true).run(args);
	}

}
