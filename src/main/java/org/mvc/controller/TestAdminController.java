package org.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin/")
public class TestAdminController {

	@RequestMapping("main")
	public String adminMain() {
		log.info("========/admin main/========");
		return "admin/main";
	}
}
