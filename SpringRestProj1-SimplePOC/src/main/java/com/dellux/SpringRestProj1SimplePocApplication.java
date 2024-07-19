package com.dellux;

import java.util.LinkedHashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestProj1SimplePocApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestProj1SimplePocApplication.class, args);
		
		/*List<String> list = List.of("AA","BB","A","BB","B","CC","C","AA","BB");
		//list.stream().map(str->str+=" Shailaja").distinct().collect(Collectors.toList()).forEach(System.out::println);
		
		list.stream().sorted((e1,e2)->{
			int l1= e1.length();
			int l2=e2.length();
			if(l1<l2) return -1;
			else if (l1>l2) return 1;
			else return e1.compareTo(e2);
		}).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("========================");
		list.stream().distinct().forEach(System.out::println);
		System.out.println("========================");
		list.stream().filter(e1->Collections.frequency(list, e1)>1).collect(Collectors.to()).forEach(System.out::println);
		
		 * Map<String,Integer>
		 * map=Map.of("Shailaja",1,"Shailaja2",2,"Shailaja3",3,"Shailaja4",4,"Shailaja5"
		 * ,5); map.entrySet().forEach(System.out::println); // non repeating chars from
		 * string //fibonacci series
		 * 
		 * int n1=0, n2=1, n3,count=10; System.out.println(n1); System.out.println(n2);
		 * for(int i=0; i<count; i++) {
		 * 
		 * 
		 * n3=n1+n2;
		 * 
		 * System.out.println(n3); n1=n2; n2=n3; }
		 */
		String str = "CAPGEMINI INDIA";
		
		char[] char1 = str.toCharArray();
		
		LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
		for(char ch:char1) {
			if(map.containsKey(ch)){
				map.put(ch, map.get(ch)+1);
			}else {
				map.put(ch, 1);
			}
		}
		map.entrySet().forEach(System.out::println); 
		 
		 
	}

}
