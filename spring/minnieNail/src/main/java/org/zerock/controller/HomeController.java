package org.zerock.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//DispacherServlet이 Frontcontroller의 역할.
//HomeController가 /슬래시만있으면 메인페이지를 처리해준다.
//패키지 만들때 top-level package를 org.zerock.controller로 입력하면 HomeController가 자동생성된다. 

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	//필요한 객체들은 매개변수로 선언하면 Spring에서 넣어준다. 
	@GetMapping("/mem/login.do")
	public String testSession(HttpSession session) {//이렇게 선언만하면 스프링에서 세션을 준다. 필요시 httpServletRequest request 처럼 필요한 객체들을 매개변수로 선언하면 스프링에서 넣어줌. 스프링을 안쓰면 HttpSession session = request.getSession() / session.setAttribute("login", ~) 이렇게 다 써서 해야 함.
		// 세션을 이용한 로그인 처리 (로그인하면 로그인정보가 세션에 저장됨.)
		session.setAttribute("id", "test");
		return "/mem/login";
	}
	
}
