package com.knoldus.springwebfluxswaggerexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@EnableWebFlux
public class SpringWebfluxSwaggerExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebfluxSwaggerExampleApplication.class, args);
	}

}
