package com.dellux.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dellux.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	
	  @Query("from EMPLOYEE_TABLE") 
	  public List<Employee> getAllEmployees();
	 
	
	
}
