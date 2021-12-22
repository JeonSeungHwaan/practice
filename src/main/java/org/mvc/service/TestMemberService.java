package org.mvc.service;

import org.mvc.bean.TestMemberDTO;

public interface TestMemberService {

	// 회원가입
	public int insertMember(TestMemberDTO member);
	
	// 회원 등급 설정
	public int insertUserAuth(TestMemberDTO member);
	
	// 프로필 사진 저장
	public int insertProfileImg(TestMemberDTO member);
	
	// 로그인
	public int memberLogin(String id);
	
	// 사용자 비밀번호 체크
	public String pwCheck(String id);
	
	// 회원 정보 출력
	public TestMemberDTO getMemberInfo(String memId);
	
	// 회원 정보 수정
	public int updateMemberInfo(TestMemberDTO member);
	
	// 회원 탈퇴
	public int deleteMemberInfo(String id);
	
	// 아이디 중복 체크
	public int idCheck(String id);
}
