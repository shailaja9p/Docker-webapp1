package com.dellux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowViewController {

	@RequestMapping("/home")
	public String showHome() {
		return "checkresult";
	}
}