package com.dellux.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dellux.entity.Tourist;
import com.dellux.service.ITouristService;

@RestController
@RequestMapping("/tourist-api")
public class ToursiRestController {
	
	@Autowired
	private ITouristService service;

	@PostMapping("/register")
	public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist){
		try {
		String msg = service.registerTourist(tourist);
		return new  ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllTourists(){
		try {
		List<Tourist> list = service.getAllTourists();
		return new  ResponseEntity<List<Tourist>>(list,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<?> getTouristById(@PathVariable Integer id){
		try {
			Tourist tourist = service.getTouristById(id);
			return new  ResponseEntity<Tourist>(tourist,HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	@GetMapping("/getTouristsByName/{name}")
	public ResponseEntity<?> getTouristsByName(@PathVariable String name){
		try {
			List<Tourist> tourist = service.getTouristByName(name);
			return new  ResponseEntity<List<Tourist>>(tourist,HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
}
