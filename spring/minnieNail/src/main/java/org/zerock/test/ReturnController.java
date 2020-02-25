package org.zerock.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReturnController {

	//return 타입의 차이 - String이 제일 편하다.
	
	
	// return type이 void인 경우는 url로 jsp를 찾는 자료로 사용한다.
	// url에 .do를 빼야함.
	// /WEB-INF/views + /void/list + .jsp
	// void는 redirect기능이 없음.
	@GetMapping("/void/list")
	public void voidTest() {
		
	}
	
	//return type이 String인 경우는 return되는 문자열로 jsp를 찾는 자료로 사용된다.
	//WEB-INF/views/ + string/list +.jsp (참고로 슬래시는 두개붙어도 한개취급되므로 앞에 붙여도 됨...)
	// url주소는 .do 외에도 본인이 지정하는 아무거나 해도 됨 여기서는 .te로 했음. 근데 하려면 통일성있게 지정해서 해야 함. 요즘에는 .do 붙이지 않고 void로도 많이 한다. 
	@GetMapping("/string/list.te")
	public String stringTest() {
		return "/string/list";
	}
	
	//return type이 ModelAndView는 return되는 객체의 데이터로 jsp를 찾는 자료로 사용한다.
	//전달되는 데이터를 같이 담아서 넘긴다. 
	@GetMapping("/modelandview/list.do")
	public ModelAndView mavTest() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mav/list"); //view에해당되는 jsp정보를 mav에 담고
		mav.addObject("name", "홍길동"); //전달하는 정보도 모델대신 modelandview에 담는다. jsp에서 ${name}치면 홍길동이 나온다. 
		return mav;
	}
}
