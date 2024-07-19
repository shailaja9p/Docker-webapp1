package com.dellux.entity;

import java.io.Serializable;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name="DEPT_TABLE")
@Data
public class Dept implements Serializable{

	@Id
	@GeneratedValue(generator = "StategyType.AUTO")
	private Integer dId;
	@NonNull
	@Column(length=20)
	private String dName;
	public Integer getdId() {
		return dId;
	}
	public String getdName() {
		return dName;
	}
	public void setdId(Integer dId) {
		this.dId = dId;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public Dept(Integer dId, String dName) {
		super();
		this.dId = dId;
		this.dName = dName;
	}
	public Dept() {
		super();
	}
	
}
