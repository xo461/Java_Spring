package org.zerock.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.zerock.member.dto.UsersDTO;


//★로그인후 원래 있던 페이지로 이동하게끔.
//servlet-xml에 등록하고, loginController 수정해야 함
//Interceptor는 Controller에 들어오는 요청(HttpRequest)과 응답(HttpResponse)를 가로채는 역할을 한다. 
//쉽게 말해 “eastglow.github.io/boardlist/10” 라는 URI를 사용자가 요청했을 때 그 요청과 받아주는 Controller가 반환하는 응답을 가로채는 녀석이다. 
//이와 비슷한 기능을 가진 Filter라는 것도 있는데 Interceptor와 다른 점은 실행되는 시점이다.
//Interceptor는 DispatcherServlet이 실행된 후(= Controller로 가기 전), Filter는 DispatcherServlet이 실행되기 전에 호출된다.

public class AuthInterceptor extends HandlerInterceptorAdapter {

	private final String[] needLoginList = {
		"/board/write.do",
		"/board/update.do",
		"/board/delete.do",
		"/bcomment/insert.do",
		"/bcomment/update.do",
		"/bcomment/increaselike.do"
	};
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		UsersDTO login = (UsersDTO) session.getAttribute("login");
		
		String uri = request.getServletPath();
		String query = request.getQueryString();
		System.out.println("AuthInterceptor.preHandle().uri: "+uri);
		System.out.println("AuthInterceptor.preHandle().query: "+query);
		
		if(login == null) {
			// 로그인이 필요한 uri인지 검사하는 메서드 처리
			if(checkLoginList(uri)) {
				// 로그인 처리가 끝나면 session에 uri를 꺼내서 요청한 페이지로 이동 시킨다.
				session.setAttribute("uri", uri+"?"+query);
				response.sendRedirect("/login/login.do");
				// 요구한 uri를 처리하지 않는다.
				return false;
			}
		}
		return super.preHandle(request, response, handler);
	}
	
	private boolean checkLoginList(String uri) {
		for(String s : needLoginList) {
			if(s.equals(uri)) return true;
		}
		return false;
	}
	
}
