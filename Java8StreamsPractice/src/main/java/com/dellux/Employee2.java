package com.dellux;

public class Employee2 {
	private int empNo;
	private String name;
	private double salary;
	private int managerId;
	public Employee2() {
		super();
	}
	public Employee2(int empNo, String name, double salary, int managerId) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.salary = salary;
		this.managerId = managerId;
	}
	public int getEmpNo() {
		return empNo;
	}
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
}
