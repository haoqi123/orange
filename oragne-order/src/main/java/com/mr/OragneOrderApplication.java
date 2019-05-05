package com.mr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OragneOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OragneOrderApplication.class, args);
	}

}
