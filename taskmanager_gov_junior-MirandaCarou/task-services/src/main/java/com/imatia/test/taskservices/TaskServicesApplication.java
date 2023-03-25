package com.imatia.test.taskservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.imatia.test")
public class TaskServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskServicesApplication.class, args);
	}

}
