package com.dellux.entity;

public class Tuple {
	private int eno;
    private String dept;
	public Tuple(int eno, String dept) {
		super();
		this.eno = eno;
		this.dept = dept;
	}
	public int getEno() {
		return eno;
	}
	public String getDept() {
		return dept;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Tuple() {
		super();
	}
}
