package com.dellux.model;

public class Company {
	private String name;
	private String address;
	private String type;
	public Company() {
		super();
	}
	public Company(String name, String address, String type, Integer size) {
		super();
		this.name = name;
		this.address = address;
		this.type = type;
		this.size = size;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	private Integer size;
}
