package com.dellux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankOperationsController {

	@GetMapping("/")
	public String showHome() {
		return "welcome";
	}
	
	@GetMapping("/balance")
	public String showBalance() {
		return "show_balance";
	}
	
	@GetMapping("/offers")
	public String showOffers() {
		return "offers";
	}
	@GetMapping("/approve")
	public String showApprove() {
		return "loan_approve";
	}
	@GetMapping("/denied")
	public String showDenied() {
		return "access_denied";
	}
	
}
