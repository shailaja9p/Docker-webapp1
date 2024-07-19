package com.dellux.cms;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/billing")
public class BillingServiceOperationsController {

	@Autowired
	private LoadBalancerClient clientComp;
	
	@GetMapping("/show")
	public ResponseEntity<String> showBillAmt(){
		double billAmt = new Random().nextDouble(1000000.0);
		
		ServiceInstance instance = clientComp.choose("PAYMENT-SERVICE");
		
		String url = instance.getUri()+"/payment/options";
		
		System.out.println(url);
		RestTemplate template = new RestTemplate();
		
		ResponseEntity<String> response = template.exchange(url, HttpMethod.GET,null,String.class);
		
		String finalResult = "BillAmount ="+billAmt+" and payment options are "+response.getBody()+"=====>From service"+url;
		
		return new ResponseEntity<String>(finalResult,HttpStatus.OK);
	}
	
	
}
