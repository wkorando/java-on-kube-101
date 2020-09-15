package com.ibm.developer.hellojavaonkube101service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

	@Value("${environment.message}")
	private String environmentMessage;

	@Value("${config-map.message}")
	private String configMapMessage;

	@Value("${my.secret.message}")
	private String mySecretMessage;

	@GetMapping("/environment")
	public String environment() {
		return environmentMessage;
	}

	@GetMapping("/configMap")
	public String configMap() {
		return configMapMessage;
	}

	@GetMapping("/mySecretMessage")
	public String mySecretMessage() {
		return mySecretMessage;
	}

}