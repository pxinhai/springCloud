package example.ui;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.client.ConfigServicePropertySourceLocator;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
@Configuration
@EnableAutoConfiguration
public class UiApp {


	@Value("${message}")
	String name = "World";

	@RequestMapping("/")
	public String home() {
		ConfigServicePropertySourceLocator ss=null;
		return "Hello " + name;
	}


	public static void main(String[] args) {
		new SpringApplication(UiApp.class).run(args);
	}
}