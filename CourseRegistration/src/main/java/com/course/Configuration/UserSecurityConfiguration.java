package com.course.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.course.Service.UserService;

@EnableWebSecurity
public class UserSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService service;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		auth.userDetailsService(service);
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoded() {
		return NoOpPasswordEncoder.getInstance();
	}
	

}


