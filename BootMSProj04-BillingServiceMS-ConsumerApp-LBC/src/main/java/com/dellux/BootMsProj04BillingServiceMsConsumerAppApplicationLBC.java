package com.dellux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BootMsProj04BillingServiceMsConsumerAppApplicationLBC {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj04BillingServiceMsConsumerAppApplicationLBC.class, args);
	}

}
