package org.mvc.service;

import java.util.List;

import org.mvc.bean.TestBoardDTO;

public interface TestBoardService {
	
	public List<TestBoardDTO> getList();
	
	public void insertContent (TestBoardDTO board);
	
	public void insertMemberContent(TestBoardDTO board);
	
	public TestBoardDTO getContent(Long bno);
	
	public String getContentPw(Long bno);
	
	public String getMemberId(Long bno);
	
	public void readCountUp(Long bno);
	
	public int updateContent(TestBoardDTO board);
	
	public int deleteContent(Long bno);
}
