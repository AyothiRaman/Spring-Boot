package com.springInterceptor.interceptor;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ProductInterceptor implements HandlerInterceptor {

	Logger log = LoggerFactory.getLogger(ProductInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("pre Handle +++++" + request.getRequestURI(), request.getMethod());
		return true;
		// HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("post Handle +++++" + request.getRequestURI(), request.getMethod());
		// HandlerInterceptor.super.postHandle(request, response, handler,
		// modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		if (ex != null) {
			log.error("exception inside" + ex.getMessage());
		}

		log.info("afterCompletion +++++" + request.getRequestURI(), request.getMethod());

		// HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
