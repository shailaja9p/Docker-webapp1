package com.dellux.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generate")
public class MessageRenderController {

	@GetMapping("/wish")
	public ResponseEntity<Map<String,Integer>> genearteWishMsg(){
		
		LocalDateTime ld = LocalDateTime.now();
		
		
		int hour = ld.getHour();
		String msg = null;
		if(hour < 12)
			msg = "Good Morning";
		if(hour < 16)
			msg = "Good Afternoon";
		else if(hour < 20 )
			msg = "Good Evening";
		else
			msg = "Good night4";
			Map<String,Integer> map = Map.of("Shailaja", 10, "suman", 20, "medha", 30, "radha", 40, "raja", 50);
		return new ResponseEntity<Map<String,Integer>>(map,HttpStatus.OK);
		
	}
	
}
