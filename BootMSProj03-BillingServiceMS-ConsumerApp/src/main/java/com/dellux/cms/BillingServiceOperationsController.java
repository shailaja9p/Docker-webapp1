package com.dellux.cms;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
	private DiscoveryClient clientComp;
	
	@GetMapping("/show")
	public ResponseEntity<String> showBillAmt(){
		double billAmt = new Random().nextDouble(1000000.0);
		
		List<ServiceInstance> list = clientComp.getInstances("PAYMENT-SERVICE");
		
		String url = list.get(0).getUri()+"/payment/options";
		
		RestTemplate template = new RestTemplate();
		
		ResponseEntity<String> response = template.exchange(url, HttpMethod.GET,null,String.class);
		
		String finalResult = "BillAmount ="+billAmt+" and payment options are "+response.getBody();
		
		return new ResponseEntity<String>(finalResult,HttpStatus.OK);
	}
	
	
}
