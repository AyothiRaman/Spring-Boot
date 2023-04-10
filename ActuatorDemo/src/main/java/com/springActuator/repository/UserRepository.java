package com.springActuator.repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.springActuator.entity.UserEntity;

@Repository
public class UserRepository {
	
	public List<UserEntity> getDetails(){
		return Stream.of(
				new UserEntity(1,"sara","sara@gmail.com", "active"),
				new UserEntity(2,"seetha","seetha@gmail.com", "Inactive"),
				new UserEntity(3,"banu","banu@gmail.com", "active"),
				new UserEntity(4,"malni","malni@gmail.com", "Inactive"))

				.collect(Collectors.toList());
		
				
	}
	
	public long getStatusCount(String status) {
		return getDetails().stream().filter(user-> user.getStatus().equals(status)).count();
	}
	
}
