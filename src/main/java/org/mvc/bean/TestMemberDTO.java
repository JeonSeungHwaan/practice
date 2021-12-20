package org.mvc.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TestMemberDTO {
	
	private String id;
	private String pw;
	private String name;
	private String nickname;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth;
	private Date regdate;
	private String img;
}
