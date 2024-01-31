package com.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationContextApplication implements CommandLineRunner {


	@Autowired
	ApplicationContextProvider applicationContextProvider;

	public static void main(String[] args) {
		SpringApplication.run(ApplicationContextApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Message message = applicationContextProvider.getApplicationContext().getBean(Message.class);
           System.out.println(message.getMessage());


	}


}
