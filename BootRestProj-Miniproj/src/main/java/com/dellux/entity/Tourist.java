package com.dellux.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "REST_TOURIST_TAB")
@Data
public class Tourist {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer tid;
	@Column(length = 20)
	private String name;
	@Column(length = 20)
	private String place;
	@Column(length = 30)
	private String packageType;
	private Double budget;
	public Tourist() {
		super();
	}
	public Tourist(String name, String place, String packageType, Double budget) {
		super();
		this.name = name;
		this.place = place;
		this.packageType = packageType;
		this.budget = budget;
	}
	public Tourist(Integer tid, String name, String place, String packageType, Double budget) {
		super();
		this.tid = tid;
		this.name = name;
		this.place = place;
		this.packageType = packageType;
		this.budget = budget;
	}
	public Integer getTid() {
		return tid;
	}
	public String getName() {
		return name;
	}
	public String getPlace() {
		return place;
	}
	public String getPackageType() {
		return packageType;
	}
	public Double getBudget() {
		return budget;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPlace(String place) {
		this.place = place;
	}
	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	

}
