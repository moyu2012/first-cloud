package com.fiberhome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConsulClientApplication {

	@Autowired
	public LoadBalancerClient loadBalancer;
	
	@Autowired
	public DiscoveryClient discoveryClient;
	
	@RequestMapping("/discovery")
	public Object discovery(){
		return loadBalancer.choose("server").getUri().toString();
	}
	
	@RequestMapping("/services")
	public Object services(){
		return discoveryClient.getInstances("server");
	}
	
	@RequestMapping("/hello")
	public String hello(){
		return "hello!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ConsulClientApplication.class, args);

	}

}
