package com.dellux.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

	@GetMapping("/home")
	public String showHome() {
		System.out.print("Good Morning");
		return "welcome";
	}
}
