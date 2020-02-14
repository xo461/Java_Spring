package com.webjjang.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webjjang.bean.Beans;
import com.webjjang.main.controller.MainController;

import static com.webjjang.util.io.ViewResolver.forward;
/**
 * Servlet implementation class MainServlet
 */


//url 패턴은 web.xml에 설정하도록 한다.
//@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 실행해야 할 컨트롤러 선언
	private Controller mainController = Beans.getController("mainController");
	private Controller boardController = Beans.getController("boardController");
	private Controller noticeController = Beans.getController("noticeController");
	private Controller imageController = Beans.getController("imageController");
	private Controller memberController = Beans.getController("memberController");
	private Controller ajaxController = Beans.getController("ajaxController");
	private Controller qnaController = Beans.getController("qnaController");
	private Controller messageController = Beans.getController("messageController");
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//.do라고만 url쓰면 여기를 거쳐서 가야함. url을 내 마음대로 만들어 쓸 수 있다.
		// forward시킬 문자열 저장변수 jsp
		String jsp = "";
		
		try {
		
		System.out.println("FrontController.service() - 시작부분");
		String uri = request.getServletPath();
		System.out.println(uri);
		if(uri.indexOf("/board") == 0) {
			System.out.println("게시판 처리");
//			url 받은걸 jsp에 담아놓는다.
			jsp = boardController.execute(request, response, uri);
		} 
		else if(uri.indexOf("/notice") ==0){
			System.out.println("공지사항 처리");
//			url 받은걸 jsp에 담아놓는다.
			jsp = noticeController.execute(request, response, uri);
		} 
		else if(uri.indexOf("/image") ==0){
			System.out.println("이미지 처리");
			jsp = imageController.execute(request, response, uri);
		} 
		else if(uri.indexOf("/qna") ==0){
			jsp = qnaController.execute(request, response, uri);
			System.out.println("질문답변 처리");
		} 
		else if(uri.indexOf("/message") ==0){
			System.out.println("메시지 처리");
			jsp = messageController.execute(request, response, uri);
		} 
		else if(uri.indexOf("/member") ==0){
			System.out.println("회원관리 처리");	
			jsp = memberController.execute(request, response, uri);
	
		} else if(uri.indexOf("/main.do") == 0){
			System.out.println("메인페이지 처리");
			//jsp = "main/main";
			jsp = mainController.execute(request, response, uri);
		}
		else if(uri.indexOf("/ajax") ==0){
			System.out.println("ajax 처리");	
			//ajax인 경우 주로 jsp를 만들지 않고 데이터를 그대로 보낸다.
			ajaxController.execute(request, response, uri);
		return;
		} else {
			System.out.println("404에러 없는 페이지 요청");
		}
		
		//viewResolver.forward를 static import해 놓아서 메소드 이름만 사용 가능하다.
		forward(request, response, jsp);
		//처리가 다 끝나면 jsp로 forward할지 url로 redirect할지 처리하는 문을 작성
	}catch (Exception e){
		throw new ServletException(e);
		
		}		
	}
}
