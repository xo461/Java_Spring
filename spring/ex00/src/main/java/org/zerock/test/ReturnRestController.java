package org.zerock.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.board.dto.BoardDTO;


//Ajax처리

// component-scan에 의해서 자동으로 생성되는 어노테이션 지정
// @Controller: url mapping이 이루어진다. forward(jsp찾기)나 redirect(url이동)를 한다.
// @Service: 데이터 처리를 총괄
// @Repository: DAO프로그램(데이터를 저장과 검색)
// @Component : 구성에 의해서 필요한 객체

// @RestController: url mapping이 이루어진다. 
//  처리된 데이터를 jsp를 거치지 않고 화면에바로 전달한다. ajax처리시 사용한다. 특히 모바일앱처럼 서버랑 직접 연결되있지 않을때...주로 xml, json데이터일때많이 쓴다. 
// 예외처리하는 어노테이션이 추가로 붙는다. @RestControllerAdvice
@RestController  //ajax를 이용하여 순수한 데이터를 받아갈때
public class ReturnRestController {

//	@GetMapping("/ajax/string.do")
	//한글처리시 아래와 같이 쓴다.
	@GetMapping(value = "/ajax/string.do", produces = "text/plain; charset=utf8")
	public String testString() {
		return "minnie미니"; //return type String이면 이 리턴값이 순수한 문자열 데이터로 처리되어 바로 전달된다.
	}

	// DTO(=VO) -> (jackson-databind라는 라이브러리를 사용하고 있어서 json데이터로 변경되어 전송된다.
	@GetMapping("/ajax/board")//http://localhost/ajax/board.json 이라고 써도 되고 .json 생략해도 된다.
	public BoardDTO testDTO() {
		BoardDTO dto = new BoardDTO();
		dto.setNo(1);
		dto.setTitle("DTO 리턴"); 
		return dto; //dto내용 json형식으로 전달됨. return type string 아닌 BoardDTO로 넘겼더니 한글 엔코딩처리 안해도 화면에 보인다.
	}

	// ajax json 배열(리스트)로 넘기기
	@GetMapping("/ajax/list")
	public List<BoardDTO> testList() {
		
		BoardDTO dto1 = new BoardDTO();
		dto1.setNo(1);
		dto1.setTitle("List 리턴"); 

		BoardDTO dto2 = new BoardDTO();
		dto2.setNo(2);
		dto2.setTitle("List 리턴2");
		
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		list.add(dto1);
		list.add(dto2);
		return list; //return type string 아닌 BoardDTO로 넘겼더니 한글 엔코딩처리 안해도 화면에 보인다.
	}
	
	
	@GetMapping(value = "/ajax/stringentity", //.do는 써도되고 안써도된다. 
			produces = "text/plain; charset=utf8")  //한글처리
	public ResponseEntity<String> testEntity(){ //return type을 지네릭<String>으로 하면 return에서 ""String외의 형식으로 리턴시 오류난다. 타입 강제함. 
		System.out.println("HttpStatus.OK:"+HttpStatus.OK);
		System.out.println("HttpStatus.BAD_REQUEST:"+HttpStatus.BAD_REQUEST);
		return new ResponseEntity<String>("minnie미니", HttpStatus.OK); //f12 network에서 확인 가능.
	}
}


