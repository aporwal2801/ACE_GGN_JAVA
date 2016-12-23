package com.main.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.main.RestController"})
public class MainController {

	
	public static void main(String[] args) {
		SpringApplication.run(MainController.class, args);
	}

}
