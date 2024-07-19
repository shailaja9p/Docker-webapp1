package com.dellux.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dellux.entity.Employee;
import com.dellux.service.EmployeeService;

@RestController
@RequestMapping("/restEmployee")
public class EmployeeController {
	
	@Autowired
	public EmployeeService service;

	@PostMapping("/save")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee emp){
		try {
		Employee response = service.saveEmployee(emp);
		return new ResponseEntity<Employee>(response,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = service.getAllEmployees();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

}
