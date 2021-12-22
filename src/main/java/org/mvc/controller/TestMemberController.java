package org.mvc.controller;

import java.io.File;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mvc.bean.TestFileInfo;
import org.mvc.bean.TestMemberDTO;
import org.mvc.service.TestMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member/")
public class TestMemberController {

	@Autowired
	private TestMemberService service;
	@Autowired
	private TestFileInfo fileInfo;
	@Setter(onMethod_=@Autowired)
	private PasswordEncoder pwencoder;
	
	@RequestMapping("main")
	public String main(Principal principal, HttpSession session) {
		
		String uri = null;
		
		if(principal == null) {
			uri = "member/all";
		} else {
			log.info("=======/User Name : " + principal.getName());
			
			TestMemberDTO member = service.getMemberInfo(principal.getName());
			
			session.setAttribute("memId", member.getId());
			session.setAttribute("nickName", member.getNickname());
			
			uri = "member/main";
		}
		
		return uri;
	}
	
	@RequestMapping("all")
	public String all() {
		return "member/all";
	}
	
	@RequestMapping("singUp")
	public String singUp(TestMemberDTO member) {
		log.info("=============/signUp/=============");
		return "member/singUp";
	}
	
	@RequestMapping("singUpPro")
	public String singUpPro(Model model, TestMemberDTO member, MultipartFile save, HttpServletRequest request) {
		log.info("=============/singUpPro/=============");
		
		model.addAttribute("result", service.insertMember(member));
		
		if(save != null) {
			if(fileInfo.fileTypeCheck(save, "image")) {
				String orgName = save.getOriginalFilename();
				String ext = orgName.substring(orgName.lastIndexOf("."));
				String fileName = member.getId() + ext;

				String path = request.getSession().getServletContext().getRealPath("/resources/member/img");
				
				File f = new File(path + "//" + fileName);
				
				try {
					save.transferTo(f);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				member.setImg(fileName);
				service.insertProfileImg(member);
			}
		}
		
		service.insertUserAuth(member);
		
		return "member/singUpPro";
	}
	
	@RequestMapping("login")
	public String login() {
		log.info("=============/login/=============");
		return "member/login";
	}
	
	@RequestMapping("loginPro")
	public String loginPro(TestMemberDTO member, HttpSession session) {
		log.info("=============/loginPro/=============");
		return "member/loginPro";
	}
	
	@RequestMapping("logout")
	public String member_logout(HttpSession session) {
		log.info("=============/logout/=============");
		session.invalidate();
		return "member/logout";
	}
	
	@RequestMapping("userInfo")
	public String member_userInfo(Model model, HttpSession session) {
		log.info("=============/member_userInfo/=============");
		
		String memId = (String)session.getAttribute("memId");
		
		model.addAttribute("memberInfo", service.getMemberInfo(memId));
		return "member/userInfo";
	} 
	
	@RequestMapping("pwCheck")
	public String member_pwCheck(TestMemberDTO member, Model model) {
		String uri;
		
		if(member.getPw() == null) {
			log.info("=============/member_pwCheck : pw null/=============");
			uri = "member/pwCheck";
		} else {
			log.info("=============/member_pwCheck : pw not null/=============");
			String DBpw = service.pwCheck(member.getId());
			if(pwencoder.matches(member.getPw(), DBpw)) {
				model.addAttribute("result", 1);
			}
			uri = "member/pwCheckPro";
		}
		
		return uri;
	}
	
	@RequestMapping("update")
	public String member_update(HttpSession session, Model model) {
		log.info("=============/member_update/=============");
		String memId = (String)session.getAttribute("memId");
		model.addAttribute("memberInfo", service.getMemberInfo(memId));
		return "member/update";
	}
	
	@RequestMapping("updatePro")
	public String member_updatePro(TestMemberDTO member, HttpServletRequest request) {
		log.info("=============/member_updatePro/=============");
		service.updateMemberInfo(member);
		return "member/updatePro";
	}
	
	@RequestMapping("imgUpdate")
	public String member_imgUpdate() {
		log.info("=============/member_imgUpdate/=============");
		return "member/imgUpdate";
	}
	
	@RequestMapping("imgUpdatePro")
	public String member_imgUpdatePro(Model model, TestMemberDTO member, MultipartFile save, HttpServletRequest request) {
		log.info("=============/member_imgUpdatePro/=============");
		
		if(save != null) {
			if(fileInfo.fileTypeCheck(save, "image")) {
				String orgName = save.getOriginalFilename();
				String ext = orgName.substring(orgName.lastIndexOf("."));
				String fileName = member.getId() + ext;

				String path = request.getSession().getServletContext().getRealPath("/resources/member/img");

				File f = new File(path + "//" + fileName);
				
				try {
					save.transferTo(f);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				member.setImg(fileName);
				service.insertProfileImg(member);
			}
		}
		
		return "member/imgUpdatePro";
	}
	
	@RequestMapping("delete")
	public String member_delete() {
		log.info("=============/member_delete/=============");
		
		return "member/delete";
	}
	
	@RequestMapping("deletePro")
	public String member_deletePro(String id, String pw, Model model, HttpSession session) {
		log.info("=============/member_deletePro/=============");
		
		String DBpw = service.pwCheck(id);
		
		if(pwencoder.matches(pw, DBpw)) {
			model.addAttribute("result", service.deleteMemberInfo(id));
			session.invalidate();
		}
		
		return "member/deletePro";
	}
	
	@RequestMapping("idCheck")
	public @ResponseBody int idCheck(String id) {
		log.info("=============/idCheck/=============");
		return service.idCheck(id);
	}
}
