package org.zerock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

@ControllerAdvice
@Log4j  //log를 만들어 가져오는 처리문을 대신한다. -> 오류나면 pom.xml에서 log4j태그의 runtime 주석처리
public class CommonExceptionAdvice {

	//500번 서버내부오류 처리하기
	@ExceptionHandler(Exception.class)
	public String except(Exception e, Model model) {
		log.error("Exception..."+e.getMessage());
		// 예외객체를 jsp에서 사용해서 예외정보를 출력하려고 한다면 데이터로 넘겨주기 위해서 모델이 필요해서 파라메터로 받음.
		model.addAttribute("exception", e); //exception을 key로 e를 
		log.error(model);
		//WEB-INF/views/ + error_page + .jsp
		return "error/error_page";
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex) {
		//WEB-INF/views/ +custom404 + .jsp
		return "error/custom404";
	}
}
