package org.zerock.util.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.zerock.member.dto.Sns_infoDTO;
import org.zerock.member.dto.UsersDTO;

//web.xml에 필터 등록해야 정상 작동함..

/**
 * Servlet Filter implementation class AuthoryFilter
 */
@WebFilter("/AuthoryFilter")
public class AuthoryFilter implements Filter {

	// 로그인 처리가 되어야 하는 URL을 저장하는 변수
	private List<String> loginList = new ArrayList<String>();
	// URL에 따른 권한을 저장하는 변수
	private Map<String, Integer> authMap = new HashMap<String, Integer>();

	/**
	 * Default constructor.
	 */
	public AuthoryFilter() {
		// TODO Auto-generated constructor stub
		// 로그인 해야할 URL 등록
		loginList.add("/board/write.do");
		loginList.add("/board/update.do");
		loginList.add("/board/delete.do");

		loginList.add("/notice/write.do");
		loginList.add("/notice/update.do");
		loginList.add("/notice/delete.do");

		// 권한 map에 권한이 필요한 URL 등록 - 일반회원(1)은 등록하지 않는다.(로그인이 되어 있는지로 확인가능)

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub

	}

	
	
	
	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		System.out.println("AuthorityFilter.doFilter");

		// 객체 캐스팅 : ServletRequest -> HttpServletRequest
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		// req에서 session 꺼내기
		HttpSession session = req.getSession();

		// req에서 session 꺼내와서 Login 정보 가져오기
		UsersDTO login = (UsersDTO) session.getAttribute("login");
		System.out.println("AuthorityFilter.doFilter().login:" + login);

		// URI 가져오기
		String uri = req.getServletPath();
		System.out.println("AuthorityFilter.doFilter().uri:" + uri);

		// 로그인이 안되 있고 로그인이 필요한 경우 바로 로그인 페이지로 이동시킨다.
		if (login == null && loginRequre(uri)) {
			// 로그인이 성공적으로 되었을 때 요청한 uri를 세션에 저장해 놓았다가
			// 바로 이동하도록 하기 위해 uri를 저장해 놓는다.
			session.setAttribute("nextURI", uri);
			session.setAttribute("msg", "<span style='color:red'>로그인이 필요한 페이지입니다.</span>");
			res.sendRedirect("/login/login.do");
			return;
		}
		
		// 여기가 요청한 처리로 이동하게 하는 부분
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	//로그인필요한지 알아내는 메소드
	private boolean loginRequre(String uri) {
		for (String str : loginList) {
			if (uri.equals(str))
				return true; //로그인이 필요하다.
		}
		return false; //로그인이 필요하지않다.
	}
	
	
}
