package com.security.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		List<String> roleNames = new ArrayList<String>();
		
		authentication.getAuthorities().forEach(authority ->{
			roleNames.add(authority.getAuthority());
			System.out.println("=========role.authority==="+authority.getAuthority());
		});
		
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/practice/admin/main");
			return ;
		}
		
		if(roleNames.contains("ROLE_MEMBER")) {
			response.sendRedirect("/practice/member/main");
			return ;
		}
		
	}
	
	
}
