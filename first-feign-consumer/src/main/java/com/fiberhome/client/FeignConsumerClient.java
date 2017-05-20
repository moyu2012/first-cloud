package com.fiberhome.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "client")
public interface FeignConsumerClient {
	@RequestMapping(value = "/from", method = RequestMethod.GET)
	String form();
}
