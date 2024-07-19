package com.dellux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dellux.entity.UserInfo;
import com.dellux.model.Product;
import com.dellux.repository.UserInfoRepository;


@Service
public class ProductService {
	

	List<Product> productList=null;
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/*
	 * @PostConstruct public void loadProductsFromDB() { productList =
	 * IntStream.rangeClosed(1, 100) .mapToObj(i-> Product.builder() .productId(i)
	 * .name("product" +i) .qty(new Random().nextInt(10)) .price(new
	 * Random().nextInt(5000)).build() ).collect(Collectors.toList()); }
	 */
	public String addUser(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		userInfoRepository.save(userInfo);
		return "user added to system";
	}
}
