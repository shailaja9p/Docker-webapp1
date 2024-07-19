package com.dellux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BootBatchProj03DbToCsvApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootBatchProj03DbToCsvApplication.class, args);
	}

}
