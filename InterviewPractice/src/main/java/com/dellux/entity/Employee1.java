package com.dellux.entity;

import java.util.List;

public class Employee1 {
	public Employee1() {
		super();
	}

	public Employee1(List<Long> mobileNos) {
		super();
		this.mobileNos = mobileNos;
	}

	public List<Long> getMobileNos() {
		return mobileNos;
	}

	public void setMobileNos(List<Long> mobileNos) {
		this.mobileNos = mobileNos;
	}

	private List<Long> mobileNos;
}
