package com.dellux.model;

import java.util.Date;

public class ExamResult {

	public ExamResult(Integer id, Date dob, Integer semester, Float percentage) {
		super();
		this.id = id;
		this.dob = dob;
		this.semester = semester;
		this.percentage = percentage;
	}
	private Integer id;
	private Date dob;
	private Integer semester;
	private Float percentage;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ExamResult() {
		super();
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
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
	
}
