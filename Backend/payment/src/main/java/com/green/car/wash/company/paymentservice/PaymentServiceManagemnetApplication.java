package com.green.car.wash.company.paymentservice;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PaymentServiceManagemnetApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceManagemnetApplication.class, args);
	}

}
