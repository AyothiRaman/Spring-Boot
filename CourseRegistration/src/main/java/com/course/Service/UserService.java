package com.course.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.course.Configuration.UserSecurityConfiguration;
import com.course.Configuration.UserSecurityDetails;
import com.course.Entity.StudentEntity;
import com.course.Entity.UserEntity;
import com.course.Repository.StudentRepository;
import com.course.Repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	
	@Autowired
	UserRepository userrepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UserEntity> security =	userrepository.findByUserName(username);
		
		if(security.isPresent()) {
			return new UserSecurityDetails(security.get());
			
		}
		else {
			throw new UsernameNotFoundException("not found");
			
		}
		
	}

}
