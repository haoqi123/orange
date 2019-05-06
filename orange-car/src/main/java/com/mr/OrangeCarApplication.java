package com.mr;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrangeCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrangeCarApplication.class, args);
	}

}
