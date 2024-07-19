package com.dellux.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping("/home")
	public String showHome() {
		System.out.print("Good Morning");
		return "welcome";
	}
}
