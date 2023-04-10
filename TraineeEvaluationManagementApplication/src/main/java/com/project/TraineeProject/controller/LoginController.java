package com.project.TraineeProject.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/login")
public class LoginController {
	
	@GetMapping
	public String getLoginPage() {
		return "login";
	}
	
	

}
