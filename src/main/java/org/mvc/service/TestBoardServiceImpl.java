package org.mvc.service;

import java.util.List;

import org.mvc.bean.TestBoardDTO;
import org.mvc.mybatis.TestBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TestBoardServiceImpl implements TestBoardService{
	
	@Autowired
	private TestBoardMapper mapper;
	
	@Override
	public List<TestBoardDTO> getList() {
		log.info("==========getList============");
		return mapper.getList();
	}
	
	@Override
	public void insertContent(TestBoardDTO board) {
		log.info("==========insertContent============");
		mapper.insertContent(board);
	}

	@Override
	public void insertMemberContent(TestBoardDTO board) {
		log.info("==========insertMemberContent============");
		mapper.insertMemberContent(board);
	}

	@Override
	public TestBoardDTO getContent(Long bno) {
		log.info("==========getContent============");
		return mapper.getContent(bno);
	}

	@Override
	public String getContentPw(Long bno) {
		return mapper.getContentPw(bno);
	}

	@Override
	public String getMemberId(Long bno) {
		return mapper.getMemberId(bno);
	}
	
	@Override
	public void readCountUp(Long bno) {
		log.info("==========readCountUp============");
		mapper.readCountUp(bno);
	}

	@Override
	public int updateContent(TestBoardDTO board) {
		log.info("==========updateContent============");
		return mapper.updateContent(board);
	}

	@Override
	public int deleteContent(Long bno) {
		log.info("==========deleteContent============");
		return mapper.deleteContent(bno);
	}

}
