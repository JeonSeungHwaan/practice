package org.mvc.bean;

import java.util.Date;

import lombok.Data;

@Data
public class TestBoardDTO {
	
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private String pw;
	private Integer readcount;
	private Date regdate;
	private Date updateDate;
	private String member_id;
}
