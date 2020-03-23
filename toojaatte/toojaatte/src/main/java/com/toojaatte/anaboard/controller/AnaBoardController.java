package com.toojaatte.anaboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.toojaatte.anaboard.dto.AnaBoardDTO;
import com.toojaatte.anaboard.service.AnaBoardService;
import com.toojaatte.util.page.PageObject;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j 
@RequestMapping("/anaboard")
public class AnaBoardController {
	@Autowired
	@Qualifier("as") //BoardService의 @Qualifier("bs")이름과 맞춘다.
	private AnaBoardService service;
	
	private final String MODULE = "anaboard";
	
	//1.게시판 리스트
	@GetMapping("/list.do") //RequestMapping + GetMapping
	public String list(Model model, PageObject pageObject) {
		//DB에서 데이터 가져오기 -> 페이지 계산, JSP에서 표시할 페이지네이션 정보가 계산된다.
		model.addAttribute("list", service.list(pageObject));
		model.addAttribute("pageObject", pageObject);
		return MODULE + "/list";
	}
	//2.게시판 글보기
	@GetMapping("/view.do")
	public String view(Model model, int no) {
		model.addAttribute("dto", service.view(no));
		return MODULE + "/view";
	}
	//3-1.게시판 글쓰기폼
	@GetMapping("/write.do")
	public String writeForm() {
		return MODULE + "/write";
	}
	//3-2.게시판 글쓰기 처리
	@PostMapping("/write.do")
	public String write(AnaBoardDTO dto) {
		service.write(dto);
		// 자동으로 list로 이동
		return "redirect:list.do";
	}
	//4-1.게시판 글수정폼
	@GetMapping("/update.do")
	public String updateForm(Model model, int no) {
		model.addAttribute("dto", service.view(no));
		return MODULE + "/update";
	}
	//4-2.게시판 글수정 처리 - 전체 데이터
	@PostMapping("/update.do")
	public String update(AnaBoardDTO dto) {
		int result = service.update(dto);
		if(result > 0)
			// 자동으로 view로 이동
			return "redirect:view.do?no=" + dto.getNo();
		else
			// 오류 보여주는 jsp 페이지로 이동
			return "error/error_pw";
	}
	//5.게시판 글삭제 처리 - 글번호, 비밀번호
	@PostMapping("/delete.do")
	public String delete(AnaBoardDTO dto) {
		service.delete(dto);
		return "redirect:list.do";
	}
}
