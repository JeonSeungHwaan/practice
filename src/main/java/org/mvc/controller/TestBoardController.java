package org.mvc.controller;

import java.util.List;

import org.mvc.bean.TestBoardDTO;
import org.mvc.service.TestBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board/")
public class TestBoardController {

	@Autowired
	private TestBoardService service;
	
	// 전체 게시글 출력
	@RequestMapping("list")
	public String list(Model model) {
		log.info("=============/practice/board/list/=============");
		
		List<TestBoardDTO> list = service.getList();
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	// 게시글 작성 폼 이동
	@RequestMapping("write")
	public String write(Model model) {
		log.info("=============/practice/board/write/=============");
		
		return "board/write";
	}
	
	// 게시글 작성
	@RequestMapping("writePro")
	public String writePro(TestBoardDTO board) {
		log.info("=============/practice/board/writePro/=============");
		
		service.insertContent(board);
		System.out.println(board);
		return "board/writePro";
	}
	
	// 조회수 증가 후 게시글 이동
	@RequestMapping("readcount")
	public String readcount(Long bno, RedirectAttributes rttr) {
		log.info("=============/practice/board/readcount?bno="+bno+"/=============");
		service.readCountUp(bno);
		rttr.addAttribute("bno", bno);
		return "redirect:/board/content";
	}
	
	// 하나의 게시글 출력
	@RequestMapping("content")
	public String content(Long bno, Model model) {
		log.info("=============/practice/board/content?bno="+bno+"/=============");
		model.addAttribute("testboardDTO", service.getContent(bno));
		return "board/content";
	}
	
	// 게시글 수정 폼 이동
	@RequestMapping("update")
	public String update(Model model, TestBoardDTO board) {
		log.info("=============/practice/board/update?bno="+board.getBno()+"/=============");
		return "board/update";
	}
	
	// 게시글 수정
	@RequestMapping("updatePro")
	public String updatePro(TestBoardDTO board, Model model) {
		log.info("=============/practice/board/updatePro?bno="+board.getBno()+"/=============");
		
		String DBpw = service.getContent(board.getBno()).getPw();
		
		if(board.getPw().equals(DBpw)) {
			model.addAttribute("result", service.updateContent(board));
		}
		
		return "board/updatePro";
	}
	
	// 게시글 삭제 폼
	@RequestMapping("delete")
	public String delete(@ModelAttribute("bno") Long bno) {
		log.info("=============/practice/board/delete?bno="+bno+"/=============");
		return "board/delete";
	}
	
	// 게시글 삭제
	@RequestMapping("deletePro")
	public String deletePro(Long bno, String pw, Model model) {
		log.info("=============/practice/board/deletePro?bno="+bno+"/=============");
		
		String DBpw = service.getContent(bno).getPw();
		
		if(pw.equals(DBpw)) {
			model.addAttribute("result", service.deleteContent(bno));
		}
		
		return "board/deletePro";
	}
}
