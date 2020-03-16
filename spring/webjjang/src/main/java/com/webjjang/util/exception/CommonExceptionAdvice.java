package com.webjjang.util.exception;

import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

//자동으로 생성되게 하는 어노테이션:
//@Controller : 서버의 uri과 메소드/클래스를 매칭시켜주는 처리 @RequestMapping
//@Service : 처리되는 프로세서를 처리해주는 객체: 호출해서 사용
//@Repository : DB연동관련
//@Component: 객체의 구성으로 포함
//@RestController: 서버의 uri를 메서드나 매칭시키는데, 순수 데이터(xml, json) 전송에 사용. sendredirect나 jsp로 보내지 않음.
//@ControllerAdvice, @RestControllerAdvice : 스프링의 예외처리 객체 : 예외와 메서드를 매칭시켜서 처리하도록
@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {

	
	// 500번 오류를 처리를 한다.	
	@ExceptionHandler(Exception.class)
	public String except(Exception e, Model model) {
		log.error("Exception....." + e.getMessage());
		// 예외객체를 JSP에서 사용해서 예외 정보를 출력하려고 한다면 데이터로 넘겨주기 위해서 
		// Model이 필요하다.
		model.addAttribute("exception", e);
		log.error(model);
		// /WEB-INF/views/ + error_page + .jsp
		return "error/error_page";
	}
	
	// 404번 오류 처리를 한다.
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException e) {
		return "error/custom404";
	}

	
	
	
}
