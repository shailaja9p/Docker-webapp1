package com.dellux.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentServiceOperationsController {


	@Value("${server.port}")
	private int serverPort; 
	
	@Value("${eureka.instance.instance-id}")
	private String instance; 
	
	@GetMapping("/options")
	public ResponseEntity<String> showMsg(){
		try {
			Thread.sleep(30000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("From service class");
		return new ResponseEntity<String>("U can do payment using G-pay,phone-pay "+instance+"........."+serverPort,HttpStatus.OK);
	}
}
