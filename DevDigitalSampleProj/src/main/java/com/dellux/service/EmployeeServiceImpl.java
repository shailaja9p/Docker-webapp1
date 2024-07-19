package com.dellux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dellux.entity.Employee;
import com.dellux.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	public EmployeeRepository repo;

	/*
	 * @Override
	 * 
	 * @Transactional public String saveEmployee(Employee emp) throws Exception{
	 * System.out.println(emp.getName()+"  "+emp.getDesig()+"  "+emp.getSalary());
	 * int id = repo.save(emp).geteId(); return "Employee is saved with the  "+id; }
	 */
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = repo.findAll();
		return list;
	}

	@Override
	public Employee saveEmployee(Employee emp) throws Exception {
		// TODO Auto-generated method stub
		return  repo.save(emp);
	} 

}
