package com.mr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.mr.order.mapper")
public class OragneOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OragneOrderApplication.class, args);
	}

}
