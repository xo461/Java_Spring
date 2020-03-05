package org.zerock.member.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.login.NaverLoginBO;
import org.zerock.login.SignupService;
import org.zerock.member.dto.UsersDTO;
import org.zerock.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	@Inject
	private SignupService signupService;
	@Inject
	private MemberService service;
	private String apiResult = null;

	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}
	
	@GetMapping("/list.do")
	public String mList(Model model) {
		model.addAttribute("list", service.list());
		return "member/list";
	}
	
	@GetMapping("/manage.do")
	public String mManageForm(Model model, list) {
		model.addAttribute("list", service.list());
		service.adminUpdate()
		return "member/manage";
	}

	//회원관리
	@PostMapping("/manage.do")
	public String mManage(UsersDTO udto) {
		service.manage(udto);
		return "redirect:list.do";
	}

	//권한처리
	@GetMapping("/noAuth.do")
	public String noAuth() {
		return "error/noauth";
	}
}
