package com.ibm.developer.hellojavaonkube101service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HealthController.class);

	private final ApplicationContext context;

	public HealthController(ApplicationContext context) {
		super();
		this.context = context;
	}

	@GetMapping("/setLivenessToFalse")
	public String setLivenessToFalse() {
		AvailabilityChangeEvent.publish(context, LivenessState.BROKEN);
		return "Application is now broken";
	}

	@GetMapping("/setReadinessToFalse")
	public String setReadinessToFalse() {
		LOGGER.info("In helloWorld");
		AvailabilityChangeEvent.publish(context, ReadinessState.REFUSING_TRAFFIC);
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.currentThread().sleep(5000);
					AvailabilityChangeEvent.publish(context, ReadinessState.ACCEPTING_TRAFFIC);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}).start();
		return "Application is now refusing traffic";
	}
}