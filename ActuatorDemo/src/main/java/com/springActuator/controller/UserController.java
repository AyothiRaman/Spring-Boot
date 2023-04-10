package com.springActuator.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springActuator.entity.UserEntity;
import com.springActuator.repository.UserRepository;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class UserController {
	
	//Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepository;
	

	
	@GetMapping("/users")
	public List<UserEntity> getUserDetails() {
	
//		logger.info("sucessfully added logger");
		
		return userRepository.getDetails();
	}
}
