package com.fiberhome.client;

import org.springframework.stereotype.Component;

@Component
public class FeignConsumerClientHystrix implements FeignConsumerClient{

	@Override
	public String form() {
		return "-1";
	}

}
