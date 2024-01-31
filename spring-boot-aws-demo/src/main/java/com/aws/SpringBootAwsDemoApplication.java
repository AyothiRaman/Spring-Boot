package com.aws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootAwsDemoApplication {

	@GetMapping("/get")
	public String hello(){
		return "hey everyone";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAwsDemoApplication.class, args);
	}

}
