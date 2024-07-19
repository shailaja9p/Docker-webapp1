package com.dellux.model;

public class Customer {

	private Integer id;
	private String name;
	private String email;
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Customer() {
		super();
	}
	public Customer(Integer id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
