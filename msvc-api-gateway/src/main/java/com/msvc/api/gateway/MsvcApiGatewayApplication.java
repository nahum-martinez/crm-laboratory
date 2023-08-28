package com.msvc.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsvcApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcApiGatewayApplication.class, args);
	}

}
