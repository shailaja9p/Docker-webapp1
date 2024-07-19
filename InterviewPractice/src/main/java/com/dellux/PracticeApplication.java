
package com.dellux;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no.of rows:");
		int n = sc.nextInt();
		for (int i = n; i > 0; i--) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			if (i == 1 || i == n)
				for (int j = 0; j <= i - 1; j++) {
					System.out.print("*" + " ");
				}
			else {
				for (int j = 1; j <= i * 2 - 1; j++) {
					if (j == 1 || j == i * 2 - 1)
						System.out.print("*");
					else
						System.out.print(" ");
				}
			}
			System.out.println();
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			if (i == 1 || i == n)
				for (int j = 0; j <= i - 1; j++) {
					System.out.print("*" + " ");
				}
			else {
				for (int j = 1; j <= i * 2 - 1; j++) {
					if (j == 1 || j == i * 2 - 1)
						System.out.print("*");
					else
						System.out.print(" ");
				}
			}
			System.out.println();
		}
		 
		/*
		 * int n=10; for(int i=1;i<=n;i++) { for(int j=1;j<=n/2;j++) { if(i==j) {
		 * for(int k=1;k<=n/2;k++) { System.out.print("*"); System.out.print(" "); } }
		 * 
		 * System.out.print(" "); } System.out.println(); }
		 */
		// student id name age address list of students list of names

		/*
		 * List<Student> list = List.of(new Student(40,"ram",18,"Hyd"), new
		 * Student(41,"ram1",18,"Hyd1"), new Student(42,"ram2",18,"1Hyd"), new
		 * Student(34,"ram6",18,"6Hyd"), new Student(39,"ram3",18,"Hyd8"));
		 * 
		 * // map of student addesses
		 * 
		 * //List<String> nameList =
		 * list.stream().map(e->e.getName()).collect(Collectors.toList());
		 * 
		 * Map<String, List<Student>> map =
		 * list.stream().collect(Collectors.groupingBy(Student::getAddress));
		 * 
		 * map.entrySet().forEach(e->{ System.out.println(e.getKey());
		 * e.getValue().forEach(e1->e1.getName()); } );
		 */
		// System.out.println(nameList);
		/*
		 * List<String> list = new LinkedList<>(); list.add("A"); list.add("E");
		 * list.add("C"); list.add("D"); list.add("B"); list.add("D"); list.add("C");
		 * list.add("D"); list.add("B"); list.add("C"); list.add("D");
		 * 
		 * 
		 * Map<String, Long> map
		 * =list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.
		 * counting()));
		 * 
		 * Collections.sort(list, (n1,n2)->{ Long freq1 = map.get(n1); Long freq2 =
		 * map.get(n2); if(freq1 != freq2) { return (int) (freq2 -freq1); } return
		 * n1.compareTo(n2);
		 * 
		 * });
		 * 
		 * list.stream().distinct().collect(Collectors.toList()).forEach(System.out::
		 * println); Integer i1=50,i2=50,i3=128,i4=128; System.out.println(i3==i4);
		 * System.out.println(i1==i2);
		 * 
		 * List<Employee1> emplist = new ArrayList<>(); emplist.add(new
		 * Employee1(List.of(1212121L,1322323L,143434343L))); emplist.add(new
		 * Employee1(List.of(2212121L,2322323L,343434343L))); emplist.add(new
		 * Employee1(List.of(3212121L,3322323L,343434343L))); emplist.add(new
		 * Employee1(List.of(4212121L,422323L,443434343L)));
		 * 
		 * 
		 * emplist.stream() .flatMap(phones->phones.getMobileNos().stream())
		 * .map(no->no+",").forEach(System.out::print);
		 */

		// System.out.println(list);

		/*
		 * Map<Integer, Integer> map = new HashMap<>();
		 * 
		 * for(int i=0; i<list.size(); i++) { map.put(list.get(i),
		 * map.getOrDefault(list.get(i), 0)+1); }
		 * 
		 * Collections.sort(list, (n1,n2)->{ int freq1 = map.get(n1); int freq2 =
		 * map.get(n2); if(freq1 != freq2) { return freq2 -freq1; } return n1-n2; });
		 * 
		 * 
		 * System.out.println(list);
		 */

		/*
		 * ArrayList list = new ArrayList(); list.add("a"); list.add("b");
		 * list.add("c"); list.add(1,"d"); System.out.println(list);
		 * 
		 * Map<Integer,Object> map = new TreeMap<Integer,Object>(); map.put(1, null);
		 * map.put(5, null); map.put(3, null); map.put(2, null); map.put(4, null);
		 * 
		 * System.out.println(map);
		 * 
		 * box obj = new box(); obj.width=10; obj.height=2; obj.length=10;
		 * 
		 * int y = obj.width * obj.height * obj.length;
		 * 
		 * System.out.println(y);
		 * 
		 * int arr[] = new int[5]; System.out.println(arr); System.out.println(arr[0]);
		 * 
		 * int var1 = 41; int var2 = ~var1; System.out.println(var1 +" "+var2);
		 * 
		 * double va1 = 1 +5; double va2 = va1/4;
		 * 
		 * int va3 = 1+5; int va4 = va3/4;
		 * 
		 * System.out.println(va2 +" "+va4);
		 * 
		 * int a = 1; int b = 2; int c; int d; c = ++b; d = a++; c++; b++; ++a;
		 * System.out.println(a+" "+b+" "+c);
		 * 
		 */

	}
}
