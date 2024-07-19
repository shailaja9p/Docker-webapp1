package com.dellux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class BootMSProj07EurekaServerForNativeConfigFile {

	public static void main(String[] args) {
		SpringApplication.run(BootMSProj07EurekaServerForNativeConfigFile.class, args);
	}

}
