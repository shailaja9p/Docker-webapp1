package com.dellux;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OccuranceOfEachChar {

	public static void main(String[] args) {

		String word = "ilovejavatechie";

		Map<String, Long> map = Arrays.stream(word.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		// map.forEach((k,v)->System.out.println(k+"="+v));
		System.out.println(map);
		
		//List of Duplicate Elements
		List<String> listOfDuplicates = Arrays.stream(word.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream()
				.filter(w -> w.getValue() > 1)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
		System.out.println(listOfDuplicates);
		
		//List of Non Duplicate Elements
		List<String> listOfNonDuplicates = Arrays.stream(word.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream()
				.filter(w -> w.getValue() == 1)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
		System.out.println(listOfNonDuplicates);

		//List of Distinct Elements
		List<String>  distinctElements = Arrays.stream(word.split("")).distinct()
				.collect(Collectors.toList());
		System.out.println(distinctElements);
		
		//Find out first non repeating element
		
		String firstNonRepeatingElement =Arrays.stream(word.split(""))
				.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
				.entrySet()
				.stream()
				.filter(w -> w.getValue() == 1).findFirst().get().getKey();
		System.out.println(firstNonRepeatingElement);
		
		// Find out first repeating element

		String firstRepeatingElement = Arrays.stream(word.split(""))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(w -> w.getValue() > 1).findFirst().get().getKey();
		System.out.println(firstRepeatingElement);

		// Second highest number
		int numbers[] = {2,21,23,43,54,24,11,29,45,61,62,41};
		
		int secondHighest = Arrays.stream(numbers)
								.boxed()
								.sorted(Comparator.reverseOrder())
								.skip(1)
								.findFirst().get();
		System.out.println(secondHighest);

		// Second lowest number
		int secondLow = Arrays.stream(numbers).boxed().sorted().skip(1).findFirst().get();
		System.out.println(secondLow);
		
		//find large string from list
		
		List<String> courses = List.of("Java","MicroServices","SpringBoot","Angular");
		String longString =courses.stream().reduce((c1,c2)->c1.length()>c2.length()?c1:c2).get();
		System.out.println(longString);
		
		//sort below list of strings based on incresing length order, 
		//if 2 strings have same length sort based on acsending order 
		//Shailaja, Suman, Medha, Angular1,Java1
		
		List<String> strings = List.of("AAAAA","AAAAAAAA","AAAAAA","BBBBB","BBBBBBBB","BBBBBB");
		List<String> sortedStrings =strings.stream().sorted((a,b)->a.length()>b.length()?-1
										:a.length()<b.length()?1
										:a.compareTo(b))
										.collect(Collectors.toList());
		System.out.println(sortedStrings);
		System.out.println("===============================");
		Arrays.stream(numbers).sorted().forEach(System.out::print);
		System.out.println("===============================");
		Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).forEach(System.out::print);
		System.out.println("-----------------------------------");
		Arrays.stream(numbers).boxed().sorted((s1,s2)->-s1.compareTo(s2)).forEach(System.out::print);
		
		System.out.println("-----------------------------------");
		// sort employee list based on dept
		
		List<Employee> empList = List.of(new Employee(101,"Shailaja","IT",80000.0),
				new Employee(201,"Sharanya","NonIT",40000.0),
				new Employee(301,"Ramya","NonIT",50000.0),
				new Employee(102,"Harika","IT",100000.0),
				new Employee(202,"Sindhuja","IT",120000.0));
		List<Employee> groupByDept = empList.stream().sorted(Comparator.comparing(Employee::getDept))
													.collect(Collectors.toList());
		System.out.println(groupByDept);
		
		empList.stream().sorted(Comparator.comparing(Employee::getDept))
		.forEach(e->System.out.println(e.getDept()));
		
		empList.stream().sorted(Comparator.comparing(Employee::getDept,Comparator.reverseOrder()))
		.forEach(e->System.out.println(e.getDept()));
		System.out.println("-----------------------------------");
		Map<Integer,String> map1 = new HashMap<Integer,String>();
		map1.put(101, "Shailaja");
		map1.put(201,"Sharanya");
		map1.put(301,"Ramya");
		map1.put(102,"Harika");
		map1.put(202,"Sindhuja");
		// sort map based on key
		map1.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		System.out.println("-----------------------------------");
		// sort map based on value
		map1.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
		System.out.println("-----------------------------------");
		Map<Integer,Employee> empMap = new HashMap<Integer,Employee>();
		empMap.put(101,new Employee(101,"Shailaja","IT",80000.0));
		empMap.put(201,new Employee(201,"Sharanya","NonIT",40000.0));
		empMap.put(301,new Employee(301,"Ramya","NonIT",50000.0));
		empMap.put(102,new Employee(102,"Harika","IT",100000.0));
		empMap.put(202,new Employee(202,"Sindhuja","IT",120000.0));
		
		//sort based on values salary of employee
		
		empMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getSalary)))
		.forEach(e->System.out.println(e.getValue().getSalary()));
		
//sort based on values salary of employee in reversed order
		System.out.println("-----------------------------------");
		empMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getSalary).reversed()))
		.forEach(e->System.out.println(e.getValue().getSalary()));
		
		//sort based on keys
		
		empMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEach(System.out::println);
		System.out.println("-----------------------------------");
		
		String[] word1 = {"hello","you","hai","how", "are","you", "all"};
		
		String lastString = Arrays.stream(word1).skip(word1.length-1).findFirst().get();
		System.out.println(lastString);
		
		String lastString1 = Arrays.stream(word1).sorted(Comparator.reverseOrder()).findFirst().get();
		System.out.println(lastString1);
		
		//reverse each word of string
		Set<String> reverseWords=Arrays.stream(word1).map(w->new StringBuilder(w).reverse().toString()).collect(Collectors.toCollection(TreeSet::new));
		System.out.println(reverseWords);
		
		//int numbers[] = {2,21,23,43,54,24,11,29,45,61,62,41};
		// sum of all numbers of above list
		 int sum = Arrays.stream(numbers).boxed().reduce((a,b)->a+b).get();
		 System.out.println(sum);
		 
		 //min
		 int min = Arrays.stream(numbers).boxed().min(Comparator.comparing(Integer::valueOf)).get();
		 System.out.println(min);
		
		//max
		 int max = Arrays.stream(numbers).boxed().max((n1,n2)->n1.compareTo(n2)).get();
		 System.out.println(max);
		 
		 //avg
		 Double avg =  Arrays.stream(numbers).boxed().mapToInt(n->n).average().getAsDouble();
		 System.out.println(avg);
		 
		 //square filter >1== average
		 
		 Double sfa = Arrays.stream(numbers).boxed().map(n->n*n).filter(n->n>100).mapToInt(n->n).average().getAsDouble();
		 System.out.println(sfa);
		//int numbers[] = {2,21,23,43,54,24,11,29,45,61,62,41};
		 
		 //limit first 5 and sum them
		 
		 int firstFiveSum = Arrays.stream(numbers).limit(5).boxed().reduce((a,b)->a+b).get();
		// System.out.println(firstFiveSum);
		 
		//skip first 5 and sum remaining
		 
		 int skipfirstFiveSum = Arrays.stream(numbers).skip(5).boxed().reduce((a,b)->a+b).get();
		 System.out.println(skipfirstFiveSum);
		 
		//skip first 5 and limit 5 and sum them
		 int skipLimit = Arrays.stream(numbers).skip(5).limit(6).boxed().reduce((a,b)->a+b).get();
		 System.out.println(skipLimit);
		 
		 List<Employee> empMapWithPhones = List.of(new Employee(101,"Shailaja","IT",80000.0,List.of(9988,8899)),
		 new Employee(201,"Sharanya","NonIT",40000.0,List.of(8899,7788)),
		 new Employee(301,"Ramya","NonIT",50000.0,List.of(7788,6677)),
		 new Employee(102,"Harika","IT",100000.0,List.of(6677,5566)),
		 new Employee(202,"Sindhuja","IT",120000.0,List.of(5566,4455)));
		 
		 empMapWithPhones.stream().map(Employee::getPhones).forEach(System.out::println);
		 empMapWithPhones.stream().flatMap(e->e.getPhones().stream()).forEach(System.out::println);
		 
		 //convert list of employees to map emp sal as key and obj as value
		 
		 Map<Integer, Long> map2 = empMapWithPhones.stream()
				 .collect(Collectors.groupingBy(Employee::getEmpNo,Collectors.counting()));
		 System.out.println("count of each dept "+map2);
		 
		 Map<Double, List<String>> map3 = empMapWithPhones.stream()
				 .collect(Collectors.groupingBy(Employee::getSalary,
						 Collectors.mapping(Employee::getName, Collectors.toList())));
		 System.out.println(map3);
		 //collect distinct dept names from emp list 
		 empMapWithPhones.stream().map(Employee::getDept).distinct().collect(Collectors.toList()).forEach(System.out::println);
		 empMapWithPhones.stream().map(Employee::getDept).collect(Collectors.toSet()).forEach(System.out::println);
		 empMapWithPhones.stream().map(Employee::getDept).collect(Collectors.toCollection(TreeSet::new)).forEach(System.out::println);
                                                                                                                                                                                                                     
		 //convert list to linkedhashmap empid as key empname as value
		 
		 Map<Integer, String> map4 = empMapWithPhones.stream()
				 .collect(Collectors.toMap(Employee::getEmpNo, Employee::getName,(x,y)->x+","+y,LinkedHashMap::new));
		 System.out.println(map4);
		 //convert ist to map empid as key name as value
		var map5 = empMapWithPhones.stream().collect(Collectors.toMap(Employee::getEmpNo, Employee::getSalary));
		 System.out.println("var hold map values "+map5);
		 
		 //compare a list by using 2 fields 
		 
		 List<Employee> empList1 = List.of(
				 	new Employee(101,"Shailaja","IT",80000.0),
					new Employee(201,"Sharanya","NonIT",40000.0),
					new Employee(301,"Ramya","NonIT",50000.0),
					new Employee(102,"Harika","IT",100000.0),
					new Employee(202,"Sindhuja","IT",120000.0));
		 
		 Comparator<Employee> c1 =Comparator.comparing(Employee::getDept);
		 Comparator<Employee> c2 =Comparator.comparing(Employee::getName);
		 
		 Comparator<Employee> c3 =c1.thenComparing(c2);
		 
		// Collections.sort(empList1,c3);
		 //System.out.println(empList1);
		 empList1.stream().sorted(c3).forEach(e->System.out.println(e.getDept()+" "+e.getName()));
		 empList1.stream().sorted(c3).collect(Collectors.toList()).forEach(e->System.out.println(e.getDept()+" "+e.getName()));
	
		 List<Integer> numbers1 = List.of(24,21,23,45,54,24,11,29,45,61,62,41);
		 
		 var sets = numbers1.stream().filter( num -> Collections.frequency(numbers1,num)>1)
				 	.collect(Collectors.toSet());
		 System.out.println(sets);
		 
		 int evenSum =numbers1.stream().filter(n->n%2==0).mapToInt(n->n).sum();
		 System.out.println(evenSum);
		 
		 int evenSum1 =numbers1.stream().filter(n->n%2!=0).collect(Collectors.summingInt(Integer::valueOf)).intValue();
		 System.out.println(evenSum1);
		 
		 final int x;
		 x= 100;
		 System.out.println(x);
	}
	
	

}

