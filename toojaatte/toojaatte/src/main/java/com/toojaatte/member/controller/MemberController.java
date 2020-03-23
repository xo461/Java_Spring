package com.toojaatte.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.toojaatte.member.dto.LoginDTO;
import com.toojaatte.member.dto.MemberDTO;
import com.toojaatte.member.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

	@Autowired
	@Qualifier("ms")
	private MemberService service;
	
	@GetMapping("/login.do")
	public String loginForm() {
		return "member/loginForm";
	}
	
	@PostMapping("/login.do")
	public String login(LoginDTO dto, HttpSession session) {
		session.setAttribute("login", service.login(dto));
		return "redirect:/main/index.do";
	}
	
	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
		session.removeAttribute("login");
		return "redirect:/main/index.do";
	}
	
	@GetMapping("signIn.do")
	public String signInForm() {
		return "member/signInForm";
	}
	
	@PostMapping("signIn.do")
	public String signIn(MemberDTO dto) {
		service.signIn(dto);
		return "redirect:/main/index.do";
		
	}
	
	@GetMapping("findIdPw.do")
	public String findIdPw() {
		return "member/findIdPw";
	}
	
}
