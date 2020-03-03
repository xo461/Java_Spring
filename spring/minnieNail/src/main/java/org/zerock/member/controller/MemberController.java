package org.zerock.member.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.member.dto.UsersDTO;
import org.zerock.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Inject
	private MemberService service;
	
	@GetMapping("/list.do")
	public String mList(Model model) {
		model.addAttribute("list", service.list());
		return "member/list";
	}
	
	@GetMapping("/manage.do")
	public String mManageForm(Model model) {
		model.addAttribute("list", service.list());
		return "member/manage";
	}

	@PostMapping("/manage.do")
	public String mManage(UsersDTO udto) {
		service.manage(udto);
		return "redirect:list.do";
	}
}
