package com.springInterceptor.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springInterceptor.interceptor.OrderInterceptor;
import com.springInterceptor.interceptor.ProductInterceptor;

@Configuration
public class InterceptConfiguration implements WebMvcConfigurer {
	
	@Autowired
	private ProductInterceptor productInterceptor;
	
	@Autowired
	private OrderInterceptor orderInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(productInterceptor).addPathPatterns("/inter**");
		
		registry.addInterceptor(orderInterceptor).addPathPatterns("/name").excludePathPatterns("order/price");
//		WebMvcConfigurer.super.addInterceptors(registry);
	}
	

}
