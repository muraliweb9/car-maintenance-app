package com.interview.carmaintenance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CarMaintenanceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarMaintenanceAppApplication.class, args);
	}

}
