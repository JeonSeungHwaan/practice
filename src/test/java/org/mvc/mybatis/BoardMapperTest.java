package org.mvc.mybatis;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mvc.bean.TestBoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTest {
	
	@Autowired
	private TestBoardMapper mapper;
	
	@Test
	public void getList() {
		List<TestBoardDTO> list = mapper.getList();
		
		for(TestBoardDTO dto : list) {
			log.info(dto);
		}
	}
	
	@Test
	public void testInsert() {
		TestBoardDTO dto = new TestBoardDTO();
		dto.setTitle("테스트 제목");
		dto.setContent("테스트 내용");
		dto.setWriter("java");
		dto.setPw("java1234");
		
		mapper.insertContent(dto);
		
		log.info(dto);
	}
}	
