package com.dellux.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dellux.model.Customer;

@RestController
@RequestMapping("/customerapi")
public class CustomerOperationsController {

	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer(@RequestBody Customer cust) {
		return new ResponseEntity<String>(cust.toString(), HttpStatus.OK);
	}

	/*
	 * @GetMapping("/report/{id}/{name}") public ResponseEntity<String>
	 * generateMessage(@PathVariable(name="name",required = false) String
	 * name, @PathVariable(required = false) String id) { System.out.println("Id ="
	 * + id + "Name = " + name); return new ResponseEntity<String>(id + "------- " +
	 * name,HttpStatus.OK); }
	 */
	@GetMapping("/report")
	public ResponseEntity<String> generateMessage(@RequestParam(required = false) String id, @RequestParam(required = false) String name) {
		System.out.println("Id =" + id + "Name = "+ name+" report data "
				+ "" );
		return new ResponseEntity<String>("report data ",HttpStatus.OK);
	}
	@GetMapping("/report/id/name")
	public ResponseEntity<String> generateMessage1(@PathVariable(required = false) String id, @PathVariable(required = false) String name) {
		System.out.println("Id =" + id + "Name = "+ name+" report data 1" );
		return new ResponseEntity<String>("report data 1",HttpStatus.OK);
	}
	@GetMapping("/report/{id}/{name}")
	public ResponseEntity<String> generateMessage2(@PathVariable(required = false) String id, @PathVariable(required = false) String name) {
		System.out.println("Id =" + id + "Name = "+ name +"  report data 2 " );
		return new ResponseEntity<String>("report data 2",HttpStatus.OK);
	}
	/*
	 * @GetMapping("/report/{id}/name") public ResponseEntity<String>
	 * generateMessage3(@PathVariable(required = false) String
	 * id, @PathVariable(required = false) String name) { System.out.println("Id ="
	 * + id + "Name = " + name); return new
	 * ResponseEntity<String>("report data 3",HttpStatus.OK); }
	 * 
	 * @GetMapping("/report/id/{name}") public ResponseEntity<String>
	 * generateMessage4(@PathVariable(required = false) String
	 * id, @PathVariable(required = false) String name) { System.out.println("Id ="
	 * + id + "Name = " + name); return new
	 * ResponseEntity<String>("report data 4",HttpStatus.OK); }
	 */

}
