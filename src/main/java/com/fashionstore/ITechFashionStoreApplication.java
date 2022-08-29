package com.fashionstore;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class ITechFashionStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ITechFashionStoreApplication.class, args);
		
	}
	
	
	@Bean
	public ModelMapper creatingBean() {
		return new ModelMapper();
	}

}
