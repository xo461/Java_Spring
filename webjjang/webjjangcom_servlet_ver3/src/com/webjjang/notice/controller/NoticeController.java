package com.webjjang.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import com.webjjang.bean.Beans;
import com.webjjang.main.Controller;
import com.webjjang.main.Execute;
import com.webjjang.main.Service;
import com.webjjang.util.page.PageObject;

//static메소드인 굥우 static import를 사용해서 메소드까지 지정해놓으면 메소드만 사용할 수 있다.

public class NoticeController implements Controller {


	//실행에 필요한 객체 선언 (컨트롤러 상속받아서 타입은 Sevice로)
	private Service listService;
	private Service viewService;
	private Service writeService;
	private Service updateService;
	private Service deleteService;
	
	//생성자 만들어서 파라메터로 받기 (service DI 적용 -> beans에서 생성 후 넣어준다.)
	public NoticeController(
			Service listService, 
			Service viewService,
			Service writeService, 
			Service updateService,
			Service deleteService) {
		// TODO Auto-generated constructor stub
		
		//생성자에서 받아온것
		this.listService = listService;
		this.viewService = viewService;
		this.writeService = writeService;
		this.updateService = updateService;
		this.deleteService = deleteService;
	
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {
		// TODO Auto-generated method stub
		
		// 공통으로 사용되는 변수
		String jsp = "";
		PageObject pageObject = PageObject.getInstance(request.getParameter("page"),
				request.getParameter("perPageNum"));
		
		// jsp에서 자바 부분을 여기에 넣는다.
		switch (uri) {
		case "/notice/list.do":
			request.setAttribute("pageObject", pageObject);
			request.setAttribute("list", Execute.service(listService, pageObject));
			jsp ="notice/list";
			break;
			
		case "/notice/view.do":
			int no = Integer.parseInt(request.getParameter("no"));
		
			//request에 실행한 결과값을 저장 -> jsp에서 꺼내 쓴다. 
			request.setAttribute("dto", Execute.service(viewService, no));
			jsp ="notice/view";
			//frontcontroller에서 forward시킨다. 
//			request.getRequestDispatcher(jsp).forward(request, response);
			break;
			
		
		case "/notice/writeForm.do":
			jsp = "notice/writeForm";
			break;
			
		//공지사항 글삭제
		case "/notice/delete.do":
			Execute.service(deleteService, Integer.parseInt(request.getParameter("no")));
		
			//request에 실행한 결과값을 저장 -> jsp에서 꺼내 쓴다. 
			
			//자동으로 리다이렉트시킨다.
			jsp ="redirect:list.do";
			//frontcontroller에서 forward시킨다. 
//			request.getRequestDispatcher(jsp).forward(request, response);
			break;
			
			
			
		default:
			break;
		}
		System.out.println("NoticeController.execute().jsp");
		return jsp;
		
	}

	}

