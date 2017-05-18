package com.fiberhome;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class GetWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetWayApplication.class, args);
	}
	
}
