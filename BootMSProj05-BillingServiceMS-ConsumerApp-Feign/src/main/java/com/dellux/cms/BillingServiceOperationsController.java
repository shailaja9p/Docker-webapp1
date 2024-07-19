package com.dellux.cms;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dellux.feign.IPaymentServiceClient;

@RestController
@RequestMapping("/billing")
public class BillingServiceOperationsController {

	@Autowired
	private IPaymentServiceClient clientComp;
	
	@GetMapping("/show")
	public ResponseEntity<String> showBillAmt(){
		double billAmt = new Random().nextDouble(1000000.0);
		
		System.out.println("Client component obj class name :: "+clientComp.getClass());		
		ResponseEntity<String> response = clientComp.getPaymentChoices();
		
		String finalResult = "BillAmount ="+billAmt+" and payment options are "+response.getBody();
		
		return new ResponseEntity<String>(finalResult,HttpStatus.OK);
	}
	
	
}
