package org.zerock.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.service.BoardService;

@Controller // 맵핑시켜줌
//@Log4j
@RequestMapping("/board") // 보드로 들어가고 밑에 메소드위에 @requestmapping에 상세 주소만 쓰면된다.
//class위에 쓰는 Requestmapping은 get, post중요하지 않지만, 밑에 메소드위에 쓰는 Request
public class BoardController {

	@Autowired
	@Qualifier("bs")
	private BoardService service;
	private final String MODULE = "board"; // 상수로 정의 ->대문자

	// **** 게시판글리스트 ****
	// 컨트롤러에서 뭐할지 메소드로 하나씩 만든다.... 리턴타입 String... 아니면 .do가 없는 경우는 void타입으로 쓴다!!! 그러면
	// 알아서 jsp찾아간다. 그러면 .do를 쓰지 않는다. 그럼 @requestMapping(안에주소)와 return값이 동일하므로
	// jsp잘찾아감.
	@RequestMapping("/list.do") // Request(url)을 맵핑 시켜야 주소 입력했을떄 페이지가 이동됨...
	// 페이지값이 안넘어올때.. 걍 리스트클랙해서들어갈때..는 param값이 전달이 안되므로 오류가 난다. 이때 @requestParam 써서
	// 디폴트값을 지정해야줘한다. (원래는 param이름이같으면 @RequestParam 없어도 매칭시켜준다...)
	// model: 개발자는 처리를 해서 데이터를 만든다 -> 디자인하는 jsp에서는 데이터를 사용한다. -->
	// dispatcherservlet에서
	//jsp파일명넘겨주므로 리턴타입 String이다.
	public String list(@RequestParam(defaultValue = "1") int page, Model model) { 
		// mapper->service->에서 가져온 내용 model에 담야아한다...
		// Model을 파라메터로 받아야 데이터를 뷰로 넘길수있다.(리스트, 글보기, 글수정에서 데이터 사용자에게 보여줘야함)
		// model 안에 HttpServletRequest request가 포함되어있다.... 
		model.addAttribute("list", service.list()); 
		// key:value형태. list라는 이름으로 데이터 넘겨줌.
		// jsp에서  "list"이름을 써서 데이터를 받는다.(el객체)
		// viewResolver에서 "/WEB-INF/views/"+"board/list"+".jsp"
		// "redirect:~~"붙으면 redirect실행, 없으면 forward된다.
		return MODULE + "/list"; // jsp파일명
	}

	// **** 게시판글쓰기폼get ****
//	@RequestMapping(value = "/write.do", method = RequestMethod.GET) // 글쓰기 폼이니까 get방식 -> 글써서 넘겨야 post
	@GetMapping("/write.do") // 글쓰기 폼이니까 get방식 -> 글써서 넘겨야 post
	public String writeForm() {
		
		return MODULE + "/write";
	}

	// **** 게시판글쓰기처리post ****
	@PostMapping("/write.do") // 글써서 넘기므로 post
	// jsp에서 form으로 넘겨온 데이터를 아래와같이 parameter에 dto로 받으면: 스프링(DispatcherServlet)이 자동으로 name속성과 dto변수명이 같은걸 맞춰서 넣어준다.
	public String write(BoardDTO dto, MultipartHttpServletRequest mpReq, HttpSession session) throws Exception {
		System.out.println("BoardController.write().dto:" + dto);
		service.write(dto, mpReq);
		return "redirect:list.do";
	}

	
	
	
	// **** 게시판글보기 ****
//	@RequestMapping(value = "/view.do", method = RequestMethod.GET) // 글써서 넘기므로 post
	@GetMapping("/view.do") // 글써서 넘기므로 post
	// 스프링(DispatcherServlet)이 웹에서 넘어오는 데이터를 BoardDTO 생성하고, BoardDTO 프로퍼티 이름과 같은 항이
	// 있으면 바로 넣어주고 넘겨준다.
	// 기본형변수+String으로 선언된 변수는 파라메터로 반드시 넘어와야 한다. 안넘어오면 오류(여기서 int no로 선언햇는데 웹페이지주소에서
	// ?no=16처럼 글번호 넘어가야되는데 빠지면 오류)
	// @RequestParam("no"):넘어오는 파라메터 이름이 no인 데이터 가져오기
	// --> 파라메터 이름과 매개변수명이 같은 경우 생략할 수 있다. (나머지메소드에서는 다 생략했음.)
	public String view(@RequestParam("no") int no, Model model) { // no는 jsp에서사용자가 보려는 글번호 넘어오므로 받는다, model은 넘길내용
		// 넘어오는 데이터 확인
		System.out.println("BoardController.view().no: " + no);
		// DB처리 -> model에 "dto"라는 이름으로 담는다. -> jsp에서 "dto"이름으로 가져다 쓰면 됨.
		model.addAttribute("dto", service.view(no));
		// 게시판리스트로 자동이동
		return MODULE + "/view";
	}

	// **** 게시판수정폼get ****
//	@RequestMapping(value = "/update.do", method = RequestMethod.GET) // 글쓰기 폼이니까 get방식 -> 글써서 넘겨야 post
	@GetMapping("/update.do") // 글쓰기 폼이니까 get방식 -> 글써서 넘겨야 post
	public String updateForm(int no, Model model) { // 업데이트폼은 수정하려면 '글번호'받아서 '글보기'에서 불러와야함.
		// DB처리 -> model에 "dto"라는 이름으로 담는다. -> jsp에서 "dto"이름으로 가져다 쓰면 됨.
		model.addAttribute("dto", service.view(no));
		return MODULE + "/update";
	}

	// **** 게시판수정처리post ****
//	@RequestMapping(value = "/update.do", method = RequestMethod.POST) // 글써서 넘기므로 post
	@PostMapping("/update.do") // 글써서 넘기므로 post
	// 스프링(DispatcherServlet)이 웹에서 넘어오는 데이터를 BoardDTO 생성하고, BoardDTO 프로퍼티 이름과 같은 항이
	// 있으면 바로 넣어주고 넘겨준다.
	public String update(BoardDTO dto) {
		// 넘어오는 데이터 확인
		System.out.println("BoardController.update().dto:" + dto);
		// DB처리
		service.update(dto);
		// 게시판리스트로 자동이동
		return "redirect:view.do?no=" + dto.getNo();
	}

	// **** 삭제처리get ****
//	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	@GetMapping("/delete.do") // 삭제는 form으로 post로 넘기는게 따로 없으므로 get
	// 스프링(DispatcherServlet)이 웹에서 넘어오는 데이터를 BoardDTO 생성하고, BoardDTO 프로퍼티 이름과 같은 항이
	// 있으면 바로 넣어주고 넘겨준다.
	public String delete(BoardDTO dto) {
		// 넘어오는 데이터 확인
		System.out.println("BoardController.delete().dto:" + dto);
		// DB처리
		service.delete(dto);
		// 게시판리스트로 자동이동
		return "redirect:list.do?page=1&perPageNo=10"; // 10 나중에 수정요망
	}
}


