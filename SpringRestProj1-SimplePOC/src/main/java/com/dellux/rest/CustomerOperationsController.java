package com.dellux.rest;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dellux.model.Company;
import com.dellux.model.Customer;

@RestController
@RequestMapping("/customerapi")
public class CustomerOperationsController {

	@GetMapping("/report1")
	public ResponseEntity<Customer> reportEmployeeData(){
		
		Customer cust = new Customer(101, "raja", 32232323.32f, 
									new String[] {"red","green","blue"}, 
									List.of("king","raj","suman"), 
									Set.of(9988776655L,2121212121L,2121213223L), 
									Map.of("aadhar",2132435465L,"pan",4345566778L), 
									new Company("shailaja", "hyd", "female", 1223));
		
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<Customer>(cust,status);
	}
}
