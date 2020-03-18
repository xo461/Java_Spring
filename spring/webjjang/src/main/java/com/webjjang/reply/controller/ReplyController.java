package com.webjjang.reply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.webjjang.reply.dto.ReplyDTO;
import com.webjjang.reply.service.ReplyService;
import com.webjjang.util.page.PageObject;
import lombok.extern.log4j.Log4j;


//dispatcherservlet이 하는일:
//1. new ReplyDTO dto = ReplyDtO; 생성한다.
//2. 변수기본값셋팅
//3. 받은데이터와 매칭이 되는 property에 값을 넣어준다.

@RestController //★리턴을 뷰로 json,xml전달한다. 아작스처리용. jsp나 url로 보내지 않는다. 
@Log4j
@RequestMapping("/reply")
//@AllArgsConstructor //생성자에 의해서 멤버 변수를 초기화시키는 작업을 한다. 근데 클래스가 없는 멤버변수같은 경우에도 주입해줄수있어서 오류날수 있고, 변수가 다른 클래스를 상속받은거면 bean이 두개가 되어, 이걸 안쓰고 주입필요한 멤버변수에만 @autowired/@inject를 써주기도 한다.
public class ReplyController {

	@Autowired
	@Qualifier("rs")
	//ReplyserviceImpl이 Replyservice상속받으므로 replycontroller에서 replyservice 변수선언시 bean이 replyservice와 replyserviceimpl 두개 가 된다 ->  같은 타입의 빈이 두 개 이상이 존재하는 경우에 스프링이 어떤 빈을 주입해야 할지 알 수 없어서 스프링 컨테이너를 초기화하는 과정에서 예외를 발생시킨다.
	//이 경우 @Qualifier을 @Autowired와 함께 사용하여 정확히 어떤 bean을 사용할지 지정하여 특정 의존 객체를 주입할 수 있도록 한다. (해당 서비스에도 @Qualifier("같은이름")어노테이션 써줘야함)
	private ReplyService service;

	//1. 댓글 리스트
	@GetMapping("/pages/{no}/{page}")//{no}: 중괄호안에 숫자가 넘어오는데 그 숫자를 no로 받겠다. 주소로 데이터를 받으므로 @pathVariable 로 받는다.
	public ResponseEntity<List<ReplyDTO>> list(Model model, @PathVariable int no, @PathVariable int page) {
		PageObject pageObject = new PageObject(page, 10);
		log.info(pageObject);
		//동기식 데이터 처리 : 브라우저의 주소가 바뀐다.
		//지금 처리는 비동기식 데이터 처리

		//@Restcontroller는 return에서 데이터를 넘기므로, model에 따로 넘기지 않는다.  
		//위에와 같으면 <>꺽쇠안에 생략 가능
		return new ResponseEntity<>(service.list(no, pageObject), HttpStatus.OK);
	}
	
	//2. 댓글 글쓰기 처리
	@PostMapping(value="/new", consumes = "application/json")
	public ResponseEntity<String> write(@RequestBody ReplyDTO dto) {
		log.info(dto);
		System.out.println(dto);
		Integer insertCount = service.write(dto); //글쓰기 성공시1 
		//삼항연산자
		return insertCount==1
				?new ResponseEntity<>("댓글이 등록되었습니다.", HttpStatus.OK)
				:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//3. 댓글 수정 처리
	@PostMapping("/update.do")
	public String update(ReplyDTO dto) {
		int result = service.update(dto); //글수정 성공시 1 리턴, 실패시 0 리턴
		if(result > 0)//성공적으로 수정되어 1이 리턴되면
			return "redirect:view.do?no="+dto.getNo();
		else 
			return "error/error_pw"; //오류페이지jsp로 이동 
	}
	
	//4. 댓글 글삭제(글번호, 비밀번호 필수로 받는다.-->따로받으면 번거로우므로 dto로 함께 받는다.)
	//비밀번호때문에 post로 넘겨야함.->ajax나 formtag로 넘겨야 한다.
	@PostMapping("/delete.do")
	public String delete(ReplyDTO dto) {
		service.delete(dto);
		return "redirect:list.do";
	}
}
