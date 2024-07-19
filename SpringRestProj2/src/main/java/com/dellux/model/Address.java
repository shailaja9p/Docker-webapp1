package com.dellux.model;

public class Address {

	private String cityname;
	private String state;
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getState() {
		return state;
	}
	@Override
	public String toString() {
		return "Address [cityname=" + cityname + ", state=" + state + "]";
	}
	public void setState(String state) {
		this.state = state;
	}
	public Address() {
		super();
	}
	public Address(String cityname, String state) {
		super();
		this.cityname = cityname;
		this.state = state;
	}
}
