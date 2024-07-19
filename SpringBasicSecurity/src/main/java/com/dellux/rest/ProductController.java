package com.dellux.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dellux.entity.UserInfo;
import com.dellux.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
		
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome this end point is not secured";
	}
	@PostMapping("/new")
	public String addNewUser(@RequestBody UserInfo userInfo) {
		return productService.addUser(userInfo);
	}
	
	@RequestMapping("/wish")
	public String greeting() {
		return "First Spring Security application.";
	}
	
	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String getAll() {
		return "all";
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String getbyId(@PathVariable int id) {
		return "getbyid "+id;
	}
}
