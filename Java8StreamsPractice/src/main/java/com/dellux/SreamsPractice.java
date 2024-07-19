package com.dellux;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class SreamsPractice {
	public static void main(String[] args) {
		List<String> words = List.of("shailaja", "aaa", "jkdkjsd", "xxx", "dshakdhj", "jdsahdjsah0", "samatha",
				"swathi");

		List<String> words1 = List.of("shailaja", "", "", "xxx", "", "jdsahdjsah0", "samatha","swathi");
List<String> collect2 = words1.stream().filter(w->w!="").collect(Collectors.toList());
		System.out.println(collect2);
		List<String> stringsSorting = words.stream()
				.sorted((w1, w2) -> w1.length() > w2.length() ? -1 : w1.length() < w2.length() ? 1 : w1.compareTo(w2))
				.collect(Collectors.toList());

//System.out.println(stringsSorting);

		// words.stream().map(w-> new
		// StringBuffer(w).reverse()).forEach(System.out::println);

		String lastelement = words.stream().skip(words.size() - 1).findFirst().get();
		// System.out.println(lastelement);

		String firstelement = words.stream().findFirst().get();
		// System.out.println(firstelement);

		String lastEle = words.stream().sorted(Comparator.reverseOrder()).findFirst().get();
		// System.out.println(lastEle);

		List<Integer> numbers = List.of(20, 21, 23, 43, 50, 40,21,23,43);
		numbers.stream().distinct().map(n->n*n).forEach(System.out::println);

		int min = numbers.stream().max(Comparator.comparing(Integer::valueOf)).get();
//System.out.println("min "+min);

		double asDouble2 = numbers.stream().map(n -> n * n).filter(n -> n > 100).mapToInt(n -> n).average()
				.getAsDouble();
		// System.out.println(asDouble2);

		int sum = numbers.stream().reduce((a, b) -> a + b).get();
		// System.out.println(sum);

		double asDouble = numbers.stream().mapToInt(n -> n).average().getAsDouble();
		// System.out.println(asDouble);

		List<Employee> empList = List.of(new Employee(101, "Shailaja", "IT", 80000.0),
				new Employee(201, "Sharanya", "NonIT", 40000.0), new Employee(301, "Ramya", "NonIT", 80000.0),
				new Employee(102, "Harika", "IT", 100000.0), new Employee(202, "Sindhuja", "IT", 120000.0));

		Entry<String, Long> entry = empList.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.counting()))
		.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		
		System.out.println(entry);

		Map<Integer,String> toMapEx=empList.stream().collect(Collectors.toMap(Employee::getEmpNo, Employee::getName));
System.out.println(toMapEx);
		
		Map<Double, List<Employee>> map = empList.stream().collect(Collectors.groupingBy(Employee::getSalary));
		//System.out.println(map);

		Map<Double, List<String>> map1 = empList.stream().collect(
				Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.toList())));
		//System.out.println(map1);
		
		//List<String> courses = List.of("BTech","mca","mba","it","csc","Electicals","BTech","mca","it","csc");
		Set<String> collect = empList.stream().map(e->e.getDept()).collect(Collectors.toSet());
		System.out.println(collect);
	}

}
