package com.webjjang.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webjjang.member.dto.LoginDTO;
import com.webjjang.member.dto.MemberDTO;
import com.webjjang.member.service.MemberService;
import com.webjjang.util.page.PageObject;


//dispatcherservlet이 하는일:
//1. new MemberDTO dto = MemberDtO; 생성한다.
//2. 변수기본값셋팅
//3. 받은데이터와 매칭이 되는 property에 값을 넣어준다.

@Controller
//@Log4j
@RequestMapping("/member")
//@AllArgsConstructor //생성자에 의해서 멤버 변수를 초기화시키는 작업을 한다. 근데 클래스가 없는 멤버변수같은 경우에도 주입해줄수있어서 오류날수 있고, 변수가 다른 클래스를 상속받은거면 bean이 두개가 되어, 이걸 안쓰고 주입필요한 멤버변수에만 @autowired/@inject를 써주기도 한다.
public class MemberController {

	@Autowired
	@Qualifier("ms")
	//MemberserviceImpl이 Memberservice상속받으므로 membercontroller에서 memberservice 변수선언시 bean이 memberservice와 memberserviceimpl 두개 가 된다 ->  같은 타입의 빈이 두 개 이상이 존재하는 경우에 스프링이 어떤 빈을 주입해야 할지 알 수 없어서 스프링 컨테이너를 초기화하는 과정에서 예외를 발생시킨다.
	//이 경우 @Qualifier을 @Autowired와 함께 사용하여 정확히 어떤 bean을 사용할지 지정하여 특정 의존 객체를 주입할 수 있도록 한다. (해당 서비스에도 @Qualifier("같은이름")어노테이션 써줘야함)
	private MemberService service;
	private final String module = "member";

	//1. 회원 리스트
	@GetMapping("/list.do")
	public String list(Model model, PageObject pageObject) { //PageObject타입의 pageObject변수명으로 parameter받겠다.
		model.addAttribute("list", service.list(pageObject));
		model.addAttribute("pageObject", pageObject);
		// WEB-INF/views/(prefix) + member/list + .jsp(surfix)
		return module + "/list";
	}

	//2. 회원 글보기
	@GetMapping("/view.do")
	public String view(Model model, int no) {
		model.addAttribute("dto", service.view(no));
		return module + "/view";
	}
	
	//3. 회원 글쓰기폼
	@GetMapping("/write.do")
	public String writeForm() {
		return module + "/write";
	}
	
	//3-1. 회원 가입 처리(사용자가 쓴 데이터 dto로 받는다. -이름같으면 스프링에서 자동맵핑시켜줌)
	@PostMapping("/write.do")
	public String write(MemberDTO dto) {
		service.write(dto);
		return "redirect:list.do";
	}

	//4. 회원 수정 폼(사용자에게 보내줄 데이터 model로 받아오고, 수정할 글번호는 사용자한테서 받아온다.)
	@GetMapping("/update.do")
	public String updateForm(Model model, int no) {
		//view에 있는 글정보를 "dto"키에 담아서 뷰로 넘긴다.
		model.addAttribute("dto", service.view(no));
		return module + "/update";
	}
	
	//4-1. 회원 수정 처리(사용자가 수정한 데이터 dto로 받는다.)
	@PostMapping("/update.do")
	public String update(MemberDTO dto) {
		int result = service.update(dto); //글수정 성공시 1 리턴, 실패시 0 리턴
		if(result > 0)//성공적으로 수정되어 1이 리턴되면
			return "redirect:view.do?id="+dto.getId();
		else 
			return "error/error_pw"; //오류페이지jsp로 이동 
	}
	
	//5. 회원 탈퇴(id, pw, email받음)
	//비밀번호때문에 post로 넘겨야함.->ajax나 formtag로 넘겨야 한다.
	@PostMapping("/delete.do")
	public String delete(MemberDTO dto) {
		service.delete(dto);
		return "redirect:list.do";
	}
	
	//6. 로그인  - 아이디와 비번을 받는회면
	@GetMapping("/login.do")
	public String loginForm() {
		return "member/login";
	}
	//6. 로그인 처리- 아이디와 비번을 받는다. - post
	@PostMapping("/login.do")
	public String login(LoginDTO dto, HttpSession session) {
		//정보가 맞으면 회원정보가 셋팅, 맞지않으면 null이 셋팅
		session.setAttribute("login", service.login(dto));
		String uri = (String) session.getAttribute("uri");
		session.removeAttribute("uri");
		return (uri == null)? "redirect:/main/main.do":
			"redirect:"+uri;
	}

	//7. 로그아웃
	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
		//세션을 지운다.
		session.invalidate();
		return "redirect:/main/main.do";
	}
}