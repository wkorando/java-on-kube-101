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

	@Value("${environment.message}")
	private String environmentMessage;
	private TaskExecutor taskExecutor;

	public Controller(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

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

	@GetMapping("/environment")
	public String environment() {
		return environmentMessage;
	}

	@GetMapping("/longRunningProcess")
	public String longRunningProcess() throws InterruptedException {
		LOGGER.info("Process Started!");
		taskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.currentThread().sleep(5000);
					LOGGER.info("Process Completed!");
				} catch (InterruptedException e) {
					LOGGER.info("Process Didn't Complete!");
				}
			}
		});
		return "Process Initiated";
	}
}
