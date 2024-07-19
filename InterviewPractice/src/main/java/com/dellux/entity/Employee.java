package com.dellux.entity;

import java.time.LocalDate;

public class Employee {
	private Integer eno;
	private String ename;
	private LocalDate dob;
	public Integer getEno() {
		return eno;
	}
	public String getEname() {
		return ename;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setEno(Integer eno) {
		this.eno = eno;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Employee(Integer eno, String ename, LocalDate dob) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.dob = dob;
	}
	public Employee() {
		super();
	}
	
}
