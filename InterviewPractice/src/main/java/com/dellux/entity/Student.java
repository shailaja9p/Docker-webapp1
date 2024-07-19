package com.dellux.entity;

public class Student {

	private Integer sid;
	private String name;
	private Integer age;
	private String address;
	public Integer getSid() {
		return sid;
	}
	public String getName() {
		return name;
	}
	public Integer getAge() {
		return age;
	}
	public String getAddress() {
		return address;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Student(Integer sid, String name, Integer age, String address) {
		super();
		this.sid = sid;
		this.name = name;
		this.age = age;
		this.address = address;
	}
	public Student() {
		super();
	}
	
}
