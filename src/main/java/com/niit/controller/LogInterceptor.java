package com.niit.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LogInterceptor implements HandlerInterceptor {

	/**
	 *	handler方法执行之前执行
	 */
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		if(handler instanceof HandlerMethod) {
			HandlerMethod method = (HandlerMethod)handler;
			System.out.println(new Date()+"--"+method.getMethod().getName()+"方法开始执行");
		}
		
		return  true;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		if(handler instanceof HandlerMethod) {
			HandlerMethod method = (HandlerMethod)handler;
			System.out.println(new Date()+"--"+method.getMethod().getName()+"方法执行结束");
		}
	}
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion方法被调用");
	}
}
