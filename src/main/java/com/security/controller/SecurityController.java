package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/security/")
public class SecurityController {

	@RequestMapping("login")
	public String login() {
		log.info("==========/security - login access/==========");
		return "/security/login";
	}
	
	@RequestMapping("logout")
	public String logout() {
		log.info("==========/security - user logout/==========");
		return "/member/all";
	}
}
