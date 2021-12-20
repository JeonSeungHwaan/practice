package org.mvc.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class LogAdvice {
	
	@Before("execution(* org.mvc.service.SampleService*.do*(..))")
	public void before() {
		
	}
}
