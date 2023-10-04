package com.viewnext.masterjava.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"com.viewnext.masterjava.app.config", "com.viewnext.masterjava.app.controller", "com.viewnext.masterjava.app.service"})
public class MicroservicioFormacionApp {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioFormacionApp.class, args);
	}
}
