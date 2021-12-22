package com.security.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mvc.mybatis.TestMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.Setter;

public class CustomLoginHandler implements AuthenticationSuccessHandler{

	@Setter(onMethod_=@Autowired)
	private TestMemberMapper mapper;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		String id = request.getParameter("username");
		int loginCheck = mapper.loginCheck(id);
		
		List<String> roleNames = new ArrayList<String>();
		
		authentication.getAuthorities().forEach(authority ->{
			roleNames.add(authority.getAuthority());
			System.out.println("=========role.authority==="+authority.getAuthority());
		});
		
		if(loginCheck == 1) {
			if(roleNames.contains("ROLE_ADMIN")) {
				response.sendRedirect("/practice/admin/main");
				return ;
			}
			
			if(roleNames.contains("ROLE_MEMBER")) {
				response.sendRedirect("/practice/member/main");
				return ;
			}
			
			response.sendRedirect("/practice/member/all");
		} else {
			response.sendRedirect("/practice/member/loginPro");
		}
		
	}
	
}
