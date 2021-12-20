package org.mvc.DTO;

import java.util.Date;

import lombok.Data;

@Data
public class MemberDTO {
	
	private String id;
	private String pw;
	private Date birth;
	private String email;
	private String name;
	
}
