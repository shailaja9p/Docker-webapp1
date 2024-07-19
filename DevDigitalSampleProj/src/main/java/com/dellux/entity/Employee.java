package com.dellux.entity;


import java.io.Serializable;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name="EMPLOYEE_TABLE")
public class Employee implements Serializable{

	@Id
	@GeneratedValue(generator = "StategyType.AUTO")
	private Integer eId;
	@NonNull
	@Column(length=20)
	private String name;
	@NonNull
	@Column(length=30)
	private String desig;
	
	@OneToMany()
	private Dept dept;
	
	@NonNull
	private Double salary;
	
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	
	public Employee() {
		super();
	}
	public Integer geteId() {
		return eId;
	}
	public String getName() {
		return name;
	}
	public String getDesig() {
		return desig;
	}
	public Double getSalary() {
		return salary;
	}
	public void seteId(Integer eId) {
		this.eId = eId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Employee(Integer eId, String name, String desig, Dept dept, Double salary) {
		super();
		this.eId = eId;
		this.name = name;
		this.desig = desig;
		this.dept = dept;
		this.salary = salary;
	}
	
	
}
