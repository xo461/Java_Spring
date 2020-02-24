package org.zerock.member.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.zerock.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	private final String Module = "member";
	
	public String list() {
		
		return Module + "/list";
	}
	
}
