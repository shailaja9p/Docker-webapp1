package com.dellux;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class FlatMApExample {

	public static void main(String[] args) {
		/*
		 * List<List<Integer>> list = List.of( List.of(10,11,12,13,14),
		 * List.of(16,17,18,19,20), List.of(21,22,23,24,25) ); long count =
		 * list.stream().flatMap(l->l.stream()).count(); System.out.println(count);
		 */
		/*
		 * List<Employee2> empList=List.of( new Employee2(42,"shailaja",45000,1), new
		 * Employee2(43,"suman",450000,2), new Employee2(44,"shailaja1",459000,12), new
		 * Employee2(45,"suman1",450700,11), new Employee2(20,"shailaja2",450070,11),
		 * new Employee2(12,"suman2",458000,12) ); Map<Integer,Long> map=
		 * empList.stream().collect(Collectors.groupingBy(Employee2::getManagerId,
		 * Collectors.counting())); System.out.println(map);
		 */

		/*
		 * Map<Integer, Employee> map = Map.of(1, new Employee(11, "shailaja", "mca",
		 * 89000), 12, new Employee(2, "suman", "mphar", 89000), 13, new Employee(21,
		 * "vikki", "mca", 89000), 14, new Employee(22, "mphar", "mca", 89000));
		 */

		/*
		 * Map<Integer, String> map1 = Map.of(11, "shailaja", 21, "suman", 3, "medha",
		 * 94, "vikki", 52, "dinni", 60, "mikki", 57, "shanvi");
		 * 
		 * Stream<Entry<Integer, String>> sorted = map1.entrySet()
		 * 
		 * .stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));
		 * 
		 * sorted.forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
		 */
		/*
		 * Map<Integer, Employee> map2 = Map.of(1, new Employee(11, "shailaja", "mca",
		 * 89000), 12, new Employee(2, "suman", "mphar", 99000), 3, new Employee(21,
		 * "vikki", "mca", 90000), 4, new Employee(22, "medha", "mca", 99999));
		 */

		// map.entrySet().stream().sorted(Map.Entry.comparingByValue(Employee::getSalary)).forEach(System.out::println);
		// map.entrySet().stream().sorted(Map.Entry.comparingByValue(Employee::getSalary)).forEach(System.out::println);
		
		
		//sort list of integers
		int numbers[] = {2,21,23,43,54,24,11,29,45,61,62,41};
		
		int evenSum = Arrays.stream(numbers).boxed().filter(n->n%2==0).mapToInt(n->n).sum();
		System.out.println("evenSum is "+evenSum);
		
		int sum = Arrays.stream(numbers).boxed().mapToInt(n->n).sum();
		System.out.println("sum is "+sum);
		
int oddSum = Arrays.stream(numbers).boxed().filter(n->n%2!=0).mapToInt(Integer::valueOf).sum();
System.out.println("odd sum "+oddSum);

int oddSum1 = Arrays.stream(numbers).filter(n->n%2!=0).reduce((a,b)->a+b).getAsInt();
System.out.println("odd sum1 "+oddSum1);
		
		List<Integer> ascList = Arrays.stream(numbers).boxed()
									  .sorted(Comparator.comparing(Integer::valueOf))
									  .collect(Collectors.toList());
        System.out.println("ascList"+ascList);
     
        //sort list of integers in reverse order
        List<Integer> intList = List.of(2,21,23,43,54,24,11,29,45,61,62,41);
        					   intList.stream()
    								  .sorted(Comparator.reverseOrder())
    								  .forEach(System.out::println);
    	
		//sort list of String 
		String[] words = {"hello","you","hai","how", "are","you", "all"};
		
		List<String> ascListOfStrings = Arrays.stream(words)
											  .sorted()
											  .collect(Collectors.toList());
	    System.out.println(ascListOfStrings);
	    

		//sort list of String in reverse order
	    List<String> descListOfStrings = Arrays.stream(words).distinct()
				  .sorted(Comparator.reverseOrder())
				  .collect(Collectors.toList());
	    System.out.println(descListOfStrings);
	    

		//sort list of Employees based on empname 
		List<Employee> empList = List.of(new Employee(101,"Shailaja","IT",80000.0),
				new Employee(201,"Sharanya","NonIT",40000.0),
				new Employee(301,"Ramya","NonIT",50000.0),
				new Employee(102,"Harika","IT",100000.0),
				new Employee(202,"Sindhuja","IT",120000.0));
		
		List<Employee> asclist =empList.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
		System.out.println(asclist);
		//sort list of Employees based on empname in reverse order
		List<Employee> desclist =empList.stream().sorted(Comparator.comparing(Employee::getName,Comparator.reverseOrder())).collect(Collectors.toList());
		System.out.println(desclist);
		
		
	
		//sort list of Employees based on age(apply reverse order on dob feild)
		
		Map<Integer,String> map2 = new HashMap<Integer,String>();
		map2.put(101, "Shailaja");
		map2.put(201,"Sharanya");
		map2.put(301,"Ramya");
		map2.put(102,"Harika");
		map2.put(202,"Sindhuja");
		//sort map based on key
		List<Entry<Integer, String>> mapCompareByKey = map2.entrySet()
															.stream()
															.sorted(Map.Entry.comparingByKey())
															.collect(Collectors.toList());
		System.out.println(mapCompareByKey);
		//sort map based on value
		List<Entry<Integer,String>> mapCompareByValue=map2.entrySet()
														  .stream()
														  .sorted(Map.Entry.comparingByValue())
														  .collect(Collectors.toList());
		System.out.println(mapCompareByValue);
		
		//sort map based on key in reverse order
		List<Entry<Integer, String>> mapCompareByKeyReverse = map2.entrySet()
																	.stream()
																	.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
																	.collect(Collectors.toList());
		System.out.println(mapCompareByKeyReverse);
				//sort map based on value in reverse order
		List<Entry<Integer,String>> mapCompareByValueReverse=map2.entrySet()
																 .stream()
																 .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
																 .collect(Collectors.toList());
		System.out.println(mapCompareByValueReverse);
		

		Map<Integer, Employee> empMap = new HashMap<Integer, Employee>();
		empMap.put(101, new Employee(101, "Shailaja", "IT", 80000.0));
		empMap.put(201, new Employee(201, "Sharanya", "NonIT", 40000.0));
		empMap.put(301, new Employee(301, "Ramya", "NonIT", 50000.0));
		empMap.put(102, new Employee(102, "Harika", "IT", 100000.0));
		empMap.put(202, new Employee(202, "Sindhuja", "IT", 120000.0));
		//sort map<Integer,Employee> based on value(based on salary)
		
		
		List<Entry<Integer,Employee>> mapCompareByEmpValue = empMap.entrySet()
												   .stream()
												   .sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getSalary)))
												   .collect(Collectors.toList());

		System.out.println(mapCompareByEmpValue);
		
//		sort map<Integer,Employee> based on value(based on salary) in reverse order
		List<Entry<Integer,Employee>> mapCompareByEmpValueReverse = empMap.entrySet()
												   .stream()
												   .sorted(Map.Entry
														       .comparingByValue(Comparator.comparing(Employee::getSalary).reversed()))
												   .collect(Collectors.toList());

		System.out.println(mapCompareByEmpValueReverse);

	}
}
