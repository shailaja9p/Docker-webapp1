package com.dellux.model;

import java.util.Date;

public class IExamResult {

	private Integer id;
	private String dob;
	private Integer semester;
	private Float percentage;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public Integer getSemester() {
		return semester;
	}
	public void setSemester(Integer semester) {
		this.semester = semester;
	}
	public Float getPercentage() {
		return percentage;
	}
	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}
	public IExamResult(Integer id, String dob, Integer semester, Float percentage) {
		super();
		this.id = id;
		this.dob = dob;
		this.semester = semester;
		this.percentage = percentage;
	}
	public IExamResult() {
		super();
	}
	
}
