package com.toojaatte.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.toojaatte.member.dto.LoginDTO;
import com.toojaatte.member.dto.MemberDTO;
import com.toojaatte.member.service.MemberService;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping(value = "/member/ajax")
public class MemberRestController {

	@Autowired
	@Qualifier("ms")
	private MemberService service;
	
	@PostMapping(value = "/loginCheck", consumes = "application/json", produces = "application/text; charset=utf8")
	public ResponseEntity<String> login(@RequestBody LoginDTO dto) {
		System.out.println("MemberRestController.login().dto : " + dto);
		LoginDTO result = service.login(dto);
		System.out.println(result);
		if(result != null) {
			return new ResponseEntity<>("로그인 성공", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("로그인 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/idCheck")
	public ResponseEntity<String> idCheck(@RequestParam String id) {
		System.out.println(id);
		String result = service.idCheck(id);
		if(result == null) {
			return new ResponseEntity<>("아이디 중복되지 않습니다", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("아이디가 중복", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/findId", consumes = "application/json", produces = "application/text; charset=utf8")
	public ResponseEntity<String> findId(@RequestBody String email) {
		String result = service.findId(email);
		System.out.println(result);
		if(result == null) {
			System.out.println(result);
			return new ResponseEntity<>("이메일과 일치하는 아이디가 없습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else {
			return new ResponseEntity<>("이메일 일치하느 아이디 온", HttpStatus.OK);
		}
	}
	
	
}
