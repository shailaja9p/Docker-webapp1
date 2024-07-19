package com.dellux.service;

import java.util.List;

import com.dellux.entity.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee emp) throws Exception;
	public List<Employee> getAllEmployees();
}
