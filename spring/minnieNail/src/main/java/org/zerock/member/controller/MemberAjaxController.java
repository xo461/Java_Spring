package org.zerock.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.member.dto.UsersDTO;
import org.zerock.member.service.SignupService;

//ajax : restController
@RestController
public class MemberAjaxController {

	@Autowired
	private SignupService service;
	
	@PostMapping("/member/signup.do")
	public String normalSignup(HttpServletRequest req, HttpSession session, UsersDTO udto) {
		udto.setUserName(req.getParameter("userName"));
		udto.setPw(req.getParameter("pw"));
		udto.setEmail(req.getParameter("email"));
		udto.setNickName(req.getParameter("nickName"));
		System.out.println("memberAjaxController:"+udto);
		int result = service.insertNormalUser(udto);
		
		// db에 저장됐으면 1, 아니면 0 출력
		System.out.println("=============================================");
		System.out.println("MemberAjaxController:db에 insert성공여부:" + result);
		System.out.println("=============================================");

		//리턴 어떻게???
		return "login/ajaxLogin";
	}
}
