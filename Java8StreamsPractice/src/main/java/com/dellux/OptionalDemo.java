package com.dellux;

import java.util.List;
import java.util.Optional;

import com.dellux.model.Customer;

public class OptionalDemo {
	public static void main(String[] args) throws Exception {
		Customer cust = new Customer(42, "shailaja", "abc");

		/*
		 * Optional<Object> opt1 = Optional.empty(); System.out.println(opt1);
		 */
		/*
		 * Optional<String> opt2 = Optional.of(cust.getEmail());
		 * System.out.println(opt2);
		 */

		Optional<String> opt3 = Optional.ofNullable(cust.getEmail());
		/*
		 * if(opt3.isPresent()) System.out.println(opt3.get());
		 */

		System.out.println(opt3.orElse("default@gmail.com"));
		//System.out.println(opt3.orElseThrow(()->new IllegalArgumentException("Email not present")));
		//System.out.println(opt3.map(String::toUpperCase).orElseGet(() -> "default"));
		
		
		List<Customer> customers =List.of(
				new Customer(42, "shailaja1", "abc"),
				new Customer(41, "shailaja2", "def"),
				new Customer(43, "shailaja3", "ghi")
				);
		customers.stream()
			.filter(customer->customer.getEmail().equals("ghi")).findAny()
			.orElseThrow(()->new Exception("no customer is present with the mail id"));
	}
}
