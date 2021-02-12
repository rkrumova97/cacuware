package com.cacuware.warehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WarehouseService {

	public static void main(String[] args) {
		SpringApplication.run(WarehouseService.class, args);
	}

}
