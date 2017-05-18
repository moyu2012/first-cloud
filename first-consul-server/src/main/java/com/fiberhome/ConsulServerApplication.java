package com.fiberhome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConsulServerApplication {
	
	@RequestMapping("/home")
	public Object home(){
		System.out.println("Hello Home!");
		return "Home";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ConsulServerApplication.class, args);

	}

}
