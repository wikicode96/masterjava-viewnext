package com.viewnext.masterjava.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.viewnext.masterjava.app.controller", "com.viewnext.masterjava.app.service"})
public class CrudCursosApp {

	public static void main(String[] args) {
		SpringApplication.run(CrudCursosApp.class, args);
	}
}
