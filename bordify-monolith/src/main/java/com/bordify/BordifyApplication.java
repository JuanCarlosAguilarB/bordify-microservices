package com.bordify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BordifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BordifyApplication.class, args);
	}

}
