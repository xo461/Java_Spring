package com.webjjang.main;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.webjjang.main.Controller;
import com.webjjang.main.Service;

public class AjaxController implements Controller{

	
	private Service memberIdCheckService;
	
	public void setMemberIdCheckService(Service memberIdCheckService) {
		// TODO Auto-generated method stub
		this.memberIdCheckService = memberIdCheckService;
	}
	//setter를 이용해서 service DI 적용 - beans에서 생성후 넣어준다.
	//ajax는 공용으로 써서 같이 수정할수있기때문에 생성자보다 setter가 더 간편핟. 
	public AjaxController() {}
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response, String uri) throws Exception {
		// TODO Auto-generated method stub
		
		//서버에서 클라이언트 방향으로 데이터를 전송하기 위한 객체
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		// jsp에서 자바 부분을 여기에 넣는다.
		switch (uri) {
		case "/ajax/idCheck.do":
			System.out.println("AjaxController.execute() - idCheck");
			//서비스를 갔다가 db에서 확인한 결과로 클라이언트에 보낼 내용을 결정한다.
			String id = (String)memberIdCheckService.service(new Object[] {request.getParameter("id")});
			if(id == null)
				out.print("<span style='color:blue'>사용 가능한 아이디 입니다.</span>");
			else
				out.print("<span style='color:red'>중복된 아이디 입니다.</span>");
			break;		
		default:
			break;
		}
		return null;	
	}


}