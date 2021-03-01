package com.orderprocessing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class OrderprocessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderprocessingApplication.class, args);
	}

}
