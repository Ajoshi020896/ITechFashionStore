package com.fashionstore;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
public class ITechFashionStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ITechFashionStoreApplication.class, args);
		System.out.println("I am the core ITechFashionStore");
		System.out.println("Bhaiya m kaam kr raha hu 8081 port p");
		
		
	}
	

	@Bean
	public RestTemplate creatingBeanRestTemplate() {
		return new RestTemplate();
	}

	
	
	@Bean
	public ModelMapper creatingBean() {
		return new ModelMapper();
	}

}
