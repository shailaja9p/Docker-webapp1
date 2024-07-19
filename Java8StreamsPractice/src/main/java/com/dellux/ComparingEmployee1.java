package com.dellux;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class ComparingEmployee1 {
	public static void main(String[] args) {
		 List<Employee1> empList=List.of(
		         new Employee1(103, "shailaja", "mca", 80000, LocalDate.of(1987, 8, 3) , List.of(2222,3333))
		         ,new Employee1(101, "suman", "sas", 900000, LocalDate.of(1983, 11, 3) , List.of(2222,3333))
		       ,new Employee1(102, "medha", "it", 50000000, LocalDate.of(2018, 3, 4) , List.of(2222,3333))
		           );
		System.out.println(empList);
		
	//	empList.stream().sorted(Comparator.comparing(Employee1::getDept)).forEach(e->System.out.println(e.getName()));

		empList.stream().sorted(Comparator.comparing(Employee1::getBirthDate,Comparator.reverseOrder())).forEach(e->System.out.println(e.getName()));

	}
}
