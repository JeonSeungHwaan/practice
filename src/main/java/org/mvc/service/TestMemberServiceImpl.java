package org.mvc.service;

import org.mvc.bean.TestMemberDTO;
import org.mvc.mybatis.TestMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TestMemberServiceImpl implements TestMemberService{

	@Setter(onMethod_=@Autowired)
	private TestMemberMapper mapper;
	
	@Setter(onMethod_=@Autowired)
	private PasswordEncoder pwencoder;
	
	@Override
	public int insertMember(TestMemberDTO member) {
		log.info("========/insertMember/========");
		member.setPw(pwencoder.encode(member.getPw()));
		return mapper.signUp(member);
	}

	@Override
	public int insertUserAuth(TestMemberDTO member) {
		log.info("========/insertUserAuth/========");
		return mapper.userAuth(member);
	}
	
	@Override
	public int insertProfileImg(TestMemberDTO member) {
		log.info("========/insertProfileImg/========");
		return mapper.imgUpload(member);
	}

	@Override
	public int memberLogin(TestMemberDTO member) {
		log.info("========/memberLogin/========");
		return mapper.loginCheck(member);
	}

	@Override
	public TestMemberDTO getMemberInfo(String memId) {
		log.info("========/getMemberInfo/========");
		return mapper.memberInfo(memId);
	}

	@Override
	public int updateMemberInfo(TestMemberDTO member) {
		log.info("========/updateMemberInfo/========");
		return mapper.memberUpdate(member);
	}

	@Override
	public int deleteMemberInfo(String id, String pw) {
		log.info("========/deleteMemberInfo/========");
		return mapper.memberDelete(id, pw);
	}

	@Override
	public int idCheck(String id) {
		log.info("========/deleteMemberInfo/========");
		return mapper.idCheck(id);
	}

}
