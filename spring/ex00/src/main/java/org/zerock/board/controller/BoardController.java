package org.zerock.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //이걸 써줘야 url이 인식된다.
public class BoardController {

	//주소 입력해서 치는건 get방식.., 처리해서 넘기는건 post방식..
	//@에서 클라이언트가 요청해서 넘어오는 주소 확인
	@RequestMapping(value = "/board/list.do", method = RequestMethod.GET)
	public String list() {
		//jsp로 가는 경로 조립
		// /WEB-INF/view/ + board/list + .jsp가 붙는다.
		return "board/list";
	}
	
	//같은 write.do이더라도 사용자가 내용입력하여 post로 넘어오면 post방식, 그게 아니면 get방식 
	@RequestMapping(value = "/board/write.do", method = RequestMethod.GET)
	public String writeForm() {
		return "board/write";
	}
	
	@RequestMapping(value = "/board/write.do", method = RequestMethod.POST)
	public String write() {
		return "redirect:list.do";
	}

	@RequestMapping(value = "/board/view.do", method = RequestMethod.GET)
	public String view() {
		return "board/view";
	}
	@RequestMapping(value = "/board/update.do", method = RequestMethod.GET)
	public String updateForm() {
		return "board/update";
	}
	@RequestMapping(value = "/board/update.do", method = RequestMethod.POST)
	public String update() {
		return "redirect:view.do";
	}
	@RequestMapping(value = "/board/delete.do", method = RequestMethod.POST)
	public String delete() {
		return "redirect:list.do";
	}

}
