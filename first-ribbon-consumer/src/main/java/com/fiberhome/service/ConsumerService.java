package com.fiberhome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fiberhome.client.ConsumerClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ConsumerService {
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "fromServiceFallback")
	public String from(){
		return restTemplate.getForEntity("http://client/from", String.class).getBody();
	}
	
	public String fromServiceFallback(){
		return "error";
	}
	
	@Autowired
	private ConsumerClient consumerClient;
	
	@HystrixCommand(fallbackMethod = "fromConsumerClient")
	public String from3(){
		return consumerClient.from();
	}
	
	public String fromConsumerClient(){
		return "-1";
	}
}
