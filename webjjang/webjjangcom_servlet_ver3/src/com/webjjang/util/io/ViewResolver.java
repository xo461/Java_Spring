package com.webjjang.util.io;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {
	//url앞뒤에 붙일것
	private static final String PREFIX = "/WEB-INF/views/";
	private static final String SURFIX = ".jsp";
	
	//jsp 파일의 위치와 파일명을 만들어내는 메소드
	public static String getJsp(String str) {
		return PREFIX + str + SURFIX;
	}
	
	//jsp 파일로 셋팅하면 jsp쪽으로 포워드시키고
	//redirect하려면 url("redirect:"+url)을 셋팅해서 사용한다.
	public static void forward(HttpServletRequest request, HttpServletResponse response, String jsp) throws IOException, ServletException {
		
//		==0은 있다는 뜻. 리다이렉트가 있으면 
		System.out.println("ViewResolver.forward().jsp:"+jsp);
		if(jsp.indexOf("redirect:") == 0) {
			//jsp로 넘어오는 데이터를 url인 경우 처리
			//앞에 붙어있는 redirect:을 제거한다.
			jsp = jsp.substring("redirect:".length());
			response.sendRedirect(jsp);
			return;
		
		}
		//jsp쪽으로 이동하기 위해 forward한다.
		//redirect 제거
		 request.getRequestDispatcher(getJsp(jsp)).forward(request, response);
		 return;
	}
	


}
