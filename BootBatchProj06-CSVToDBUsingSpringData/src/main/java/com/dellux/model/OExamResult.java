package com.dellux.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BATCH_DATA_EXAM_RESULT")
public class OExamResult {
	@Id
	private Integer id;
	private LocalDate dob;
	private Integer semester;
	private Float percentage;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
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
	public OExamResult(Integer id, LocalDate dob, Integer semester, Float percentage) {
		super();
		this.id = id;
		this.dob = dob;
		this.semester = semester;
		this.percentage = percentage;
	}
	public OExamResult() {
		super();
	}
	
}
