package org.zerock.member.controller;


import java.math.BigInteger;
import java.security.SecureRandom;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.board.controller.BoardController;
import org.zerock.member.service.MemberService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService service;
	private final String Module = "member";
	
	public String list() {
		return Module + "/list";
	}
	
	@RequestMapping(value="login.do", method=RequestMethod.GET)
	public String loginGET() {
		return "member/login";
	}
	
	@RequestMapping(value="loginPostNaver.do", method=RequestMethod.GET)
	public String loginPOSTNaver(HttpSession session) {
		return "member/loginPostNaver";
	}
	
	
}
