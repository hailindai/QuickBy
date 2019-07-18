package com.florist;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.florist.order.mapper")
public class StartOrder {
	public static void main(String[] args) {
		SpringApplication.run(StartOrder.class, args);
	}
}
