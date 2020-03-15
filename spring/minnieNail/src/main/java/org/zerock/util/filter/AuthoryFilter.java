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

import org.zerock.member.dto.UsersDTO;
import org.zerock.member.service.MemberService;

//web.xml에 필터 등록해야 정상 작동함..

/**
 * Servlet Filter implementation class AuthoryFilter
 */
@WebFilter("/AuthoryFilter")
public class AuthoryFilter implements Filter {

	// 로그인 처리가 되어야 하는 URL을 저장하는 변수
	private List<String> loginList = new ArrayList<String>();
	// URL에 따른 권한을 저장하는 변수key, value
	private Map<String, Integer> authMap = new HashMap<String, Integer>();

	private MemberService service ;
	
	/**
	 * Default constructor.
	 */
	public AuthoryFilter() {
		// TODO Auto-generated constructor stub
		// 로그인 해야할 URL 등록
//		loginList.add("/board/write.do");
//		loginList.add("/board/update.do");
//		loginList.add("/board/delete.do");
//
//		loginList.add("/notice/write.do");
//		loginList.add("/notice/update.do");
//		loginList.add("/notice/delete.do");
		
//		loginList.add("/bcomment/insert.do");
//
//		//map<key, value>: (권한이 필요한 URL, uri에서 요구하는 회원등급)
//		authMap.put("/notice/write.do", 9);
//		authMap.put("/notice/update.do", 9);
//		authMap.put("/notice/delete.do", 9);
//		
//		authMap.put("/member/list.do", 9);
//		authMap.put("/member/manage.do", 9);

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub

	}

	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// 객체 캐스팅 : ServletRequest -> HttpServletRequest
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		// req에서 session 꺼내기
		HttpSession session = req.getSession();

		// req에서 session 꺼내와서 Login 정보 가져오기
		UsersDTO login = (UsersDTO) session.getAttribute("login"); //logincontroller에서 저장해놓은것
		System.out.println("AuthorityFilter.doFilter().session에저장된loginDTO:" + login);		
				
		// URI 가져오기
		String uri = req.getServletPath();
//		System.out.println("AuthorityFilter.doFilter().uri:" + uri);

		// 로그인이 안되 있고 로그인이 필요한 경우 바로 로그인 페이지로 이동시킨다.
		if (login == null && loginRequre(uri)) {
			// 로그인이 성공적으로 되었을 때 요청한 uri를 세션에 저장해 놓았다가
			// 바로 이동하도록 하기 위해 uri를 저장해 놓는다.
			session.setAttribute("nextURI", uri);
			session.setAttribute("msg", "<span style='color:red'>로그인이 필요한 페이지입니다.</span>");
			res.sendRedirect("/login/login.do");
			return;
		}
		
		//-------------------------------------------------------
		// 지정한 권한 미만인 경우 권한 부족 페이지로 이동시킨다.
		// 네이버아이디로로그인이므로 세션에서 가져오면 거기에 회원등급정보는 없다. -> logincontroller에서 로그인할때 네이버에서 주는 세션정보 이미 db에 있으면 아무처리안하고 없으면 db에 저장시킨 후에 sns_id와 동일한 데이터를 dto형태로 가져와서 세션에 저장시킨다.
		if (login != null && !checkAuth(login.getGradeNo(), uri)) { //로그인을 했고, uri에서 요구하는 회원등급보다 낮으면(false)
			System.out.println("AuthorityFilter.doFilter().loginDTO.getGradeNo():" + login.getGradeNo());		
			res.sendRedirect("/member/noAuth.do");
			return; // 아래 부분은 처리가 안된다.
		}

		//----------------------------------------------
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
	

	// 권한이 있는지 알아 내는 메서드
	private boolean checkAuth(int userGrade, String uri) {
		Integer pageGrade = authMap.get(uri); //key에 해당하는 value(회원등급)가져와서 변수저장 (해당uri가 요구하는 회원등급)
		if (pageGrade == null || userGrade >= pageGrade) //uri에서 요구하는 회원등급이 없거나, 있어도 사용자의회원등급보다 낮으면 true 리턴(uri서비스 이용 가능)
			return true;
		return false;
	}
	
}
