package com.florist;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan("com.florist.product.mapper")
@EnableEurekaClient
public class StarterProductCenter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(StarterProductCenter.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate initRestTemplateProduct(){
		return new RestTemplate();
	}
}

