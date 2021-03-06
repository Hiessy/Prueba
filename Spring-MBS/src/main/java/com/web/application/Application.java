package com.web.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.web")
@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}
