package com.ibm.developer.hellojavaonkube101service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.task.TaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

	@GetMapping
	public String helloWorld() {
		LOGGER.info("In helloWorld");
		return "Hello World!";
	}

	@GetMapping("/{name}")
	public String helloName(@PathVariable String name) {
		LOGGER.info("In helloName: " + name);
		return String.format("Hello, %s!", name);
	}
}
