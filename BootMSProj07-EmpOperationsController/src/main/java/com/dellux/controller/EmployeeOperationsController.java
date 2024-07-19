package com.dellux.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/emp")
public class EmployeeOperationsController {

	@Value("${dbuser}")
	private String dbuser;
	
	@Value("${dbpwd}")
	private String dbpwd;
	
	@GetMapping("/show")
	public String showBillAmt(){
		
		
		return "db connected with "+dbuser+"....."+dbpwd;
	}
	
	
}