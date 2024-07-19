package com.dellux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class BootMsProj07ConfigServerProjForNativeConfigFileApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj07ConfigServerProjForNativeConfigFileApplication.class, args);
	}

}
