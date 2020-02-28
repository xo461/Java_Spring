package com.webjjang.bean;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.util.HashMap;
import java.util.Map;

import com.webjjang.board.controller.BoardController;
import com.webjjang.board.dao.BoardDAO;
import com.webjjang.board.service.BoardDeleteService;
import com.webjjang.board.service.BoardListService;
import com.webjjang.board.service.BoardReplyDeleteService;
import com.webjjang.board.service.BoardReplyListService;
import com.webjjang.board.service.BoardReplyUpdateService;
import com.webjjang.board.service.BoardReplyWriteService;
import com.webjjang.board.service.BoardUpdateService;
import com.webjjang.board.service.BoardViewService;
import com.webjjang.board.service.BoardWriteService;
import com.webjjang.image.controller.ImageController;
import com.webjjang.image.dao.ImageDAO;
import com.webjjang.image.service.ImageDeleteService;
import com.webjjang.image.service.ImageListService;
import com.webjjang.image.service.ImageUpdateService;
import com.webjjang.image.service.ImageViewService;
import com.webjjang.image.service.ImageWriteService;
import com.webjjang.main.AjaxController;
import com.webjjang.main.Controller;
import com.webjjang.main.Service;
import com.webjjang.main.controller.MainController;
import com.webjjang.member.controller.MemberController;
import com.webjjang.member.dao.MemberDAO;
import com.webjjang.member.service.MemberIdCheckService;
import com.webjjang.member.service.MemberJoinService;
import com.webjjang.member.service.MemberLoginService;
import com.webjjang.notice.controller.NoticeController;
import com.webjjang.notice.dao.NoticeDAO;
import com.webjjang.notice.service.NoticeDeleteService;
import com.webjjang.notice.service.NoticeListService;
import com.webjjang.notice.service.NoticeUpdateService;
import com.webjjang.notice.service.NoticeViewService;
import com.webjjang.notice.service.NoticeWriteService;
import com.webjjang.qna.controller.QnaController;
import com.webjjang.qna.dao.QnaDAO;
import com.webjjang.qna.service.QnaListService;
import com.webjjang.qna.service.QnaUpdateService;
import com.webjjang.qna.service.QnaViewService;
import com.webjjang.qna.service.QnaWriteService;

/**
 * Servlet implementation class Beans
 */

//loadOnStartup = 1 : 서버가 시작되면 /Beans를 가장 먼저 실행해라.
@WebServlet(urlPatterns = "/init", loadOnStartup = 1)
public class Beans extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	키를 던지면 찾아오는게 맵.
//요청이 들어오면 controller - service - dao 순서로 넘어간다. 
//	boardlist라고 던지면 그거에 해당하는 밸류를 가져옴..String이 키고 그 뒤가 밸류
//	new를 안해도 memory에 올라가도록 static
//	키는 문자열이므로 String
	//dao는 list, view 이런 서비스별로 데이터 타입이 다르기때문에 공통으로 상속받는 Object를 value로 넣는다. 알아서 캐스팅함. 
	//Map이 인터페이스, HashMap이 Map 상속받은것.

	// 여기서는 각각의 객체를 저장할 map객체 선언하고 생성해 놓는다.
	private static Map<String, Controller> controllers = new HashMap<>();
	private static Map<String, Service> services = new HashMap<>();
	private static Map<String, Object> daos = new HashMap<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Beans() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		// 클래스가 시작될때 딱한번만 실행된다. -> static 블록 호출 당한다.
		
		System.out.println("Beans.inti() = static{} 블록");
		System.out.println("객체 초기화 중 .....");
		
		
		// **********공지사항**************
		// daos 생성 저장
		//선언해둔 daos 변수에 put메소드를 이용해서 실제적인 key 이름 boardDAO 넣고, BoardDAO를 생성해서 value값으로 지정해둔다. 	
		daos.put("noticeDAO", new NoticeDAO());
		// service 생성 저장
		//선언해둔 services변수에 key이름 선언하고, value로 위 dao 변수의 key값 boardDAO를 넣어서, 그거에 해당되는 value인 BoardDAO를 가져온다. 
		//위에 daos의 value는 Object로 선언했으므로 BoardDAO로 캐스팅해줘야 실제 BoardDAO가 된다. 

		services.put("noticeListService", new NoticeListService((NoticeDAO) daos.get("noticeDAO")));
		services.put("noticeViewService", new NoticeViewService((NoticeDAO) daos.get("noticeDAO")));
		services.put("noticeWriteService", new NoticeWriteService((NoticeDAO) daos.get("noticeDAO")));
		services.put("noticeUpdateService", new NoticeUpdateService((NoticeDAO) daos.get("noticeDAO")));
		services.put("noticeDeleteService", new NoticeDeleteService((NoticeDAO) daos.get("noticeDAO")));

		
		// controller 생성 저장
				controllers.put("noticeController",
						new NoticeController(
								services.get("noticeListService"), 
								services.get("noticeViewService"),
								services.get("noticeWriteService"), 
								services.get("noticeUpdateService"),
								services.get("noticeDeleteService")));

				
		
		// **********회원관리**************
		// daos 생성저장
		daos.put("memberDAO", new MemberDAO());
		// service 생성 저장
		services.put("memberJoinService", new MemberJoinService((MemberDAO) daos.get("memberDAO")));
		services.put("memberLoginService", new MemberLoginService((MemberDAO) daos.get("memberDAO")));

		// controller 생성 저장
				controllers.put("memberController",
						new MemberController(
								services.get("memberListService"), 
								services.get("memberViewService"),
								services.get("memberWriteService"), 
								services.get("memberUpdateService"),
								services.get("memberDeleteService")));

				
		
		// **********게시판**************
		// daos 생성 저장
		daos.put("boardDAO", new BoardDAO());
		// service 생성 저장
		services.put("boardListService", new BoardListService((BoardDAO) daos.get("boardDAO")));
		services.put("boardViewService", new BoardViewService((BoardDAO) daos.get("boardDAO")));
		services.put("boardWriteService", new BoardWriteService((BoardDAO) daos.get("boardDAO")));
		services.put("boardUpdateService", new BoardUpdateService((BoardDAO) daos.get("boardDAO")));
		services.put("boardDeleteService", new BoardDeleteService((BoardDAO) daos.get("boardDAO")));
		services.put("boardReplyListService", new BoardReplyListService((BoardDAO) daos.get("boardDAO")));
		services.put("boardReplyWriteService", new BoardReplyWriteService((BoardDAO) daos.get("boardDAO")));
		services.put("boardReplyUpdateService", new BoardReplyUpdateService((BoardDAO) daos.get("boardDAO")));
		services.put("boardReplyDeleteService", new BoardReplyDeleteService((BoardDAO) daos.get("boardDAO")));
		
		// controller 생성 저장
		controllers.put("boardController",
				new BoardController(
						services.get("boardListService"), 
						services.get("boardViewService"),
						services.get("boardWriteService"), 
						services.get("boardUpdateService"),
						services.get("boardDeleteService"),
						services.get("boardReplyListService"), 
						services.get("boardReplyWriteService"), 
						services.get("boardReplyUpdateService"), 
						services.get("boardReplyDeleteService")));

		
		
		// **********질문답변**************
		// daos 생성저장
		daos.put("qnaDAO", new QnaDAO());
		// service 생성 저장
		services.put("qnaWriteService", new QnaWriteService((QnaDAO) daos.get("qnaDAO")));
		services.put("qnaListService", new QnaListService((QnaDAO) daos.get("qnaDAO")));
		services.put("qnaViewService", new QnaViewService((QnaDAO) daos.get("qnaDAO")));
		services.put("qnaUpdateService", new QnaUpdateService((QnaDAO) daos.get("qnaDAO")));

		System.out.println("객체 초기화 완료 .....");

		// controller 생성 저장
		controllers.put("qnaController",
				new QnaController(
						services.get("qnaListService"), 
						services.get("qnaViewService"),
						services.get("qnaWriteService"), 
						services.get("qnaUpdateService"),
						services.get("qnaDeleteService")));


		// **********Ajax 처리 등록**************
		//아이디 중복 체크 dao -> memberDAO(이미 등록되어 있음)
		//아이디 중복체크 서비스 등록
		services.put("memberIdCheckService", new MemberIdCheckService((MemberDAO)daos.get("memberDAO")));
		//Controller 생성 저장 > 기본 생성자 -> DI 적용은 setter를 이용해서 한다.
		AjaxController ajaxController = new AjaxController();
		controllers.put("ajaxController", ajaxController);
		//ajaxController에 대한 DI 적용을 setter를 이용하여 한다.
		ajaxController.setMemberIdCheckService(services.get("memberIdCheckService"));
		
		System.out.println("객체 초기화 완료 ...");
		
		
		
		//***************이미지 *************
		daos.put("imageDAO", new ImageDAO());
		services.put("imageListService", new ImageListService((ImageDAO) daos.get("imageDAO")));
		services.put("imageViewService", new ImageViewService((ImageDAO) daos.get("imageDAO")));
		services.put("imageWriteService", new ImageWriteService((ImageDAO) daos.get("imageDAO")));
		services.put("imageUpdateService", new ImageUpdateService((ImageDAO) daos.get("imageDAO")));
		services.put("imageDeleteService", new ImageDeleteService((ImageDAO) daos.get("imageDAO")));

		System.out.println("객체 초기화 완료 .....");

		// controller 생성 저장
		controllers.put("imageController",
				new ImageController(
						services.get("imageListService"), 
						services.get("imageViewService"),
						services.get("imageWriteService"), 
						services.get("imageUpdateService"),
						services.get("imageDeleteService")));

		
		
		// **********Main Controller등록**************
		controllers.put("mainController", new MainController(services.get("noticeListService"), services.get("imageListService")));
		
		
		
		
	} // end of init()

	
	
	// Controller 를 받아내는 메서드 작성
	public static Service getService(String name) {
		return services.get(name);

	}

	public static Controller getController(String name) {
		// TODO Auto-generated method stub
		return controllers.get(name);
	}

} // end of Beans class
