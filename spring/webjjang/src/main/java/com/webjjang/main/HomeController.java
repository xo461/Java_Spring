package com.webjjang.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	
	//local로 들어오면 밑에local/main/main.do로 바로 보낸다.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "redirect:/main/main.do";
	}

	//메인에 꾸밀 service들을 불러온다.
	@RequestMapping(value = "/main/main.do", method = RequestMethod.GET)
	public String main(Model model) {
		return "home";
	}
}
