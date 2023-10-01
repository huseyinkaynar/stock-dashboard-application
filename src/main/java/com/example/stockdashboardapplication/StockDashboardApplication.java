package com.example.stockdashboardapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class StockDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockDashboardApplication.class, args);
	}

}
