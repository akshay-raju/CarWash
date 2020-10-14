package com.service.carwashpackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class CarWashPackagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarWashPackagesApplication.class, args);
	}

}
