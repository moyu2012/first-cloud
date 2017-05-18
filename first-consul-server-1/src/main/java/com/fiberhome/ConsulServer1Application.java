package com.fiberhome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConsulServer1Application {
	
	@RequestMapping("/home")
	public Object home(){
		System.out.println("Hello Home1!");
		return "Home1";
	}
	public static void main(String[] args) {
		SpringApplication.run(ConsulServer1Application.class, args);

	}

}
