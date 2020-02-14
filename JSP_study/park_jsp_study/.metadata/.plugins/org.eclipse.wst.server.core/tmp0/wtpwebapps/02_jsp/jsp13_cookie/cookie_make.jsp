<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%
 request.setCharacterEncoding("utf-8");
 %>
 
 <html> 
 	<body>
 	<%
 String visitor=request.getParameter("visitor");
 	 Cookie cookie=new Cookie("visitor", URLEncoder.encode(visitor));//쿠키생성 cookie(key, value)
 	 cookie.setMaxAge(30*24*60*60); //쿠키 유효기간 설정 30일*24시간*60분*60초
 			 
 			 //클라이언트에 쿠키를 심는다 
 			response.addCookie(cookie);
 	 %>
 	 
 	 <a href="cookie_view.jsp">cookie_view.jsp 돌아가기</a>
 	 
 	</body>
 </html>
 