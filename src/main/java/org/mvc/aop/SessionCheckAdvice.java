package org.mvc.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class SessionCheckAdvice {
	
	@Pointcut("execution(* org.mvc.controller..member*(..))")
	public void sessionCheck() {}
	
	@Around("sessionCheck()")
	public Object around(ProceedingJoinPoint jp)throws Throwable {
		log.info("===========/around - before/===========");
		
		// around 에서는 메게변수로 파라미터나 세션을 받을 수 없음
		// 때문에 파라미터와 세션을 받을 수 있도록 하는 코드를 별도 작성
		
		// 현재 실행중인 Servlet 설정 정보를 모두 가져옴
		RequestAttributes ra = RequestContextHolder.currentRequestAttributes();
		
		// Servlet 설정 정보에서 Request를 꺼내기 위해 타입 변경
		ServletRequestAttributes sra = (ServletRequestAttributes)ra;
				
		// 타입 변경된 객체에서 Request 객체를 가져옴
		HttpServletRequest request = sra.getRequest();
				
		// Request에서 session 객체를 가져옴
		HttpSession session = request.getSession();
				
		if(session.getAttribute("memId") == null) {
			return "member/login";
		}
		
		return jp.proceed();
	}
}
