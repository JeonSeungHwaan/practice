package org.mvc.mybatis;

import java.util.List;

import org.mvc.bean.TestBoardDTO;

public interface TestBoardMapper {
	
	public List<TestBoardDTO> getList();
	
	public void insertContent(TestBoardDTO board);
	
	public TestBoardDTO getContent(Long bno);
	
	public void readCountUp(Long bno);
	
	public int updateContent(TestBoardDTO board);
	
	public int deleteContent(Long bno);
}
