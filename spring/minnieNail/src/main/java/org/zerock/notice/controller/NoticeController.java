package org.zerock.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.notice.dto.NoticeDTO;
import org.zerock.notice.service.NoticeService;


@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	private final String MODULE = "notice"; //상수로 정의 ->대문자

	@RequestMapping("/list.do")
	public String list(Model model) {
		model.addAttribute("list", service.list());
		return MODULE + "/list";
	}
	
	@GetMapping("/write.do")
	public String writeForm() {
		return MODULE + "/write";
	}

	
	@PostMapping("/write.do")
	public String write(NoticeDTO dto) {
		System.out.println("NoticeController.write().dto:"+dto);
		service.write(dto);
		return "redirect:list.do";
	}
	
}
