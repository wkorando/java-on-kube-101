package com.ibm.developer.hellojavaonkube101service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
public class HelloJavaOnKube101ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloJavaOnKube101ServiceApplication.class, args);
	}
}
