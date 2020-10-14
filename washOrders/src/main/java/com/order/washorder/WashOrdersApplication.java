package com.order.washorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
@EnableDiscoveryClient
@SpringBootApplication
@EnableZuulProxy
public class WashOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(WashOrdersApplication.class, args);
	}

}
