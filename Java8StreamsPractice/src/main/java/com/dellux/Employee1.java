package com.dellux;

import java.time.LocalDate;
import java.util.List;

public class Employee1 {

	private int empNo;
	private String name;
	private String dept;
	private double salary;
	private LocalDate birthDate;
	private List<Integer> phones;
	public int getEmpNo() {
		return empNo;
	}
	public String getName() {
		return name;
	}
	public String getDept() {
		return dept;
	}
	public double getSalary() {
		return salary;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public List<Integer> getPhones() {
		return phones;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public void setPhones(List<Integer> phones) {
		this.phones = phones;
	}
	public Employee1(int empNo, String name, String dept, double salary, LocalDate birthDate, List<Integer> phones) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.birthDate = birthDate;
		this.phones = phones;
	}
	public Employee1() {
		super();
	}
	
}
