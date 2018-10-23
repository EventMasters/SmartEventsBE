package com.sample.smartevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@EnableTransactionManagement()
@EnableSpringDataWebSupport
public class SmartEventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartEventsApplication.class, args);
	}
}
