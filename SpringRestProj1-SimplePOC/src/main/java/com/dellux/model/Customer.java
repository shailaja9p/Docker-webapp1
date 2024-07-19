package com.dellux.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Customer {
	private Integer cno;
	private String cname;
	private float billAmount;
	private String[] favColors;
	private List<String> nickNames;
	private Set<Long> phoneNumbers;
	private Map<String,Object> idDetails;
	private Company company;
	public Integer getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public float getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(float billAmount) {
		this.billAmount = billAmount;
	}
	public String[] getFavColors() {
		return favColors;
	}
	public void setFavColors(String[] favColors) {
		this.favColors = favColors;
	}
	public List<String> getNickNames() {
		return nickNames;
	}
	public void setNickNames(List<String> nickNames) {
		this.nickNames = nickNames;
	}
	public Set<Long> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(Set<Long> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public Map<String, Object> getIdDetails() {
		return idDetails;
	}
	public void setIdDetails(Map<String, Object> idDetails) {
		this.idDetails = idDetails;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Customer(Integer cno, String cname, float billAmount, String[] favColors, List<String> nickNames,
			Set<Long> phoneNumbers, Map<String, Object> idDetails, Company company) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.billAmount = billAmount;
		this.favColors = favColors;
		this.nickNames = nickNames;
		this.phoneNumbers = phoneNumbers;
		this.idDetails = idDetails;
		this.company = company;
	}
	public Customer() {
		super();
	}
}
