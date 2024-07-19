package com.dellux.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Customer {

	public Customer() {
		super();
	}
	public Customer(Integer cno, String cname, Double billAmt, Address adress, String[] nickNames, List<String> friends,
			Set<Long> phonenumbers, Map<String, Long> idDeatails) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.billAmt = billAmt;
		this.adress = adress;
		this.nickNames = nickNames;
		this.friends = friends;
		this.phonenumbers = phonenumbers;
		this.idDeatails = idDeatails;
	}
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
	public Double getBillAmt() {
		return billAmt;
	}
	public void setBillAmt(Double billAmt) {
		this.billAmt = billAmt;
	}
	public Address getAdress() {
		return adress;
	}
	public void setAdress(Address adress) {
		this.adress = adress;
	}
	public String[] getNickNames() {
		return nickNames;
	}
	public void setNickNames(String[] nickNames) {
		this.nickNames = nickNames;
	}
	public List<String> getFriends() {
		return friends;
	}
	public void setFriends(List<String> friends) {
		this.friends = friends;
	}
	public Set<Long> getPhonenumbers() {
		return phonenumbers;
	}
	public void setPhonenumbers(Set<Long> phonenumbers) {
		this.phonenumbers = phonenumbers;
	}
	public Map<String, Long> getIdDeatails() {
		return idDeatails;
	}
	public void setIdDeatails(Map<String, Long> idDeatails) {
		this.idDeatails = idDeatails;
	}
	private Integer cno;
	private String cname;
	private Double billAmt;
	private Address adress;
	private String[] nickNames;
	private List<String> friends;
	private Set<Long> phonenumbers;
	private Map<String,Long> idDeatails;
	@Override
	public String toString() {
		return "Customer [cno=" + cno + ", cname=" + cname + ", billAmt=" + billAmt + ", adress=" + adress
				+ ", nickNames=" + Arrays.toString(nickNames) + ", friends=" + friends + ", phonenumbers="
				+ phonenumbers + ", idDeatails=" + idDeatails + "]";
	}
}

	