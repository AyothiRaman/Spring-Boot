package com.springInterceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@GetMapping("/name")
	public String orderName() {
		return "one plus mobile";
	}

	@GetMapping("order/price")
	public int mobilePrice() {
		return 30000;
	}
}
