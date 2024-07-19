package com.dellux;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BootSchedulingProj1Application {

	public static void main(String[] args) {
		SpringApplication.run(BootSchedulingProj1Application.class, args);
		System.out.println("Application started at "+new Date());
	}

}
