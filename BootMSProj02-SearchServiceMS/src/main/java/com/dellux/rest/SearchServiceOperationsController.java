package com.dellux.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SearchService")
public class SearchServiceOperationsController {

	@GetMapping("/show")
	public ResponseEntity<String> showMsg(){
		System.out.println("From service class");
		return new ResponseEntity<String>("Welcome to MS Development",HttpStatus.OK);
	}
}
