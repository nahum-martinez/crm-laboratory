package com.msvc.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsvcPersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcPersonApplication.class, args);
	}

}
