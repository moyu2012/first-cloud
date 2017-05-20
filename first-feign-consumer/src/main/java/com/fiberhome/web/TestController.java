package com.fiberhome.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fiberhome.client.FeignConsumerClient;

@RestController
public class TestController {

	@Autowired
	FeignConsumerClient feignConsumerClient;
	
	@RequestMapping(value = "/from",method=RequestMethod.GET)
	public String from(){
		return feignConsumerClient.form();
	}
}
