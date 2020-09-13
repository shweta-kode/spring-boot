package com.spring.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.project.domain.User;

@SpringBootApplication
public class SpringMySqlCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMySqlCrudApplication.class, args);
		
		User user = new User();
		user.setName("John");
		user.setContactNo("34535234");
	}

}
