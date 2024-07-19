package com.dellux.entity;

public class Emp {
	private int eno;
    private String ename;
    private String dept;
    private int salary;
	public int getEno() {
		return eno;
	}
	public String getEname() {
		return ename;
	}
	public String getDept() {
		return dept;
	}
	public int getSalary() {
		return salary;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Emp(int eno, String ename, String dept, int salary) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.dept = dept;
		this.salary = salary;
	}
	public Emp() {
		super();
	}
	@Override
	public String toString() {
		return "Emp [eno=" + eno + ", ename=" + ename + ", dept=" + dept + ", salary=" + salary + "]";
	}
    
}
