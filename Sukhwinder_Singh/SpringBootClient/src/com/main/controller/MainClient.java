package com.main.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.rest.Controller"})
public class MainClient {

	public static void main(String[] args) {
	SpringApplication.run(MainClient.class, args);
	}

}
