package com.lacia.api;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class LaciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaciaApplication.class, args);
	}

}
