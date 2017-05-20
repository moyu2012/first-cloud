package com.fiberhome.client;

import org.springframework.stereotype.Component;

@Component
public class ConsumerClientHystrix implements ConsumerClient{

	@Override
	public String from() {
		return Integer.toString(-1);
	}

	
}
