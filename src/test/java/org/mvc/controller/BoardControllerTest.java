package org.mvc.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration // Servlet을 사용하기 위함 - 웹 테스트 진행 가능
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class BoardControllerTest {
	
	// Servlet 요청객체
	@Setter(onMethod_=@Autowired)
	private WebApplicationContext ctx;
	
	// URL을 실행하는 것 처럼 만들어주는 객체 (테스트용 MVC)
	private MockMvc mockMvc; 
	
	// 테스트가 진행되기 전에 가장 먼저 실행되는 메소드
	@Before 
	public void setUp() {
		// 테스트용 MVC 환경 구성
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testGetList() throws Exception {
		log.info("=========================");
		log.info(mockMvc.perform(MockMvcRequestBuilders
				.get("/test/board/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
		log.info("=========================");
	}
}
