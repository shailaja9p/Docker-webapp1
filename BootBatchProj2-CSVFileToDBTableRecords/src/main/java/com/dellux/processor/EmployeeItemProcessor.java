package com.dellux.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.dellux.model.Employee;

@Component("empProcessor")
public class EmployeeItemProcessor implements ItemProcessor<Employee, Employee> {

	@Override
	public Employee process(Employee item) throws Exception {
		if(item.getSalary()>10000) {
			item.setGrossSalary(item.getSalary()+(item.getSalary()*0.4f));
			item.setNetSalary(item.getGrossSalary()-(item.getGrossSalary()*0.2f));
		return item;
		}
		return null;
	}

}
