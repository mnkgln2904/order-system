package com.ordercommand.order_command_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ordercommand.order_command_service.repository")
@EntityScan(basePackages = "com.ordercommand.order_command_service.model")
public class OrderCommandServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderCommandServiceApplication.class, args);
	}

}
