package org.mvc.mybatis;

import org.apache.ibatis.annotations.Param;
import org.mvc.bean.TestMemberDTO;

public interface TestMemberMapper {
	
	// 회원가입
	public int signUp(TestMemberDTO member);
	
	// 회원 등급 설정
	public int userAuth(TestMemberDTO member);
	
	// 프로필 사진 저장
	public int imgUpload(TestMemberDTO member);
	
	// 로그인
	public int loginCheck(TestMemberDTO member);
	
	// 회원 정보 출력
	public TestMemberDTO memberInfo(String memId);
	
	// 회원 정보 수정
	public int memberUpdate(TestMemberDTO member);
	
	// 회원 탈퇴
	public int memberDelete(@Param("id")String id, @Param("pw")String pw);
	
	// 아이디 중복 체크
	public int idCheck(String id);
}
