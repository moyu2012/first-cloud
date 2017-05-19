package com.fiberhome.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	public LoadBalancerClient loadBalancer;
	
	@Autowired
	public DiscoveryClient discoveryClient;
	
	@RequestMapping("/discovery")
	public Object discovery(){
		return loadBalancer.choose("client").getUri().toString();
	}
	
	@RequestMapping("/services")
	public Object services(){
		return discoveryClient.getInstances("client");
	}
	
	@RequestMapping(value="/from", method = RequestMethod.GET)
	public String from(){
		return restTemplate.getForEntity("http://client/from",String.class).getBody();
	}
	
}
