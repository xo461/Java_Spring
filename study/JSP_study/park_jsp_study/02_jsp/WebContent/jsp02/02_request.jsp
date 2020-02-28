<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>02_request.jsp</title>
</head>
<body>
<h2>미니's 홈</h2>

<%
String ip = request.getRemoteAddr();
if(ip.equals("192.168.1.00")){
	out.println("이 ip로는 접속할 수 없습니다.");
	return;
}
// 위의 IP로 이 페이지에 접속하는것을 차단시킴
%>

<li> 메서드 방식: <%= request.getMethod() %>
<li> 요청 URI: <%= request.getRequestURI() %>
<li> 요청 URL: <%= request.getRequestURL() %>
<p>
<li> 프로토콜 : <%=request.getProtocol() %>
<li> 서버이름 : <%=request.getServerName() %> 
<li> 서버포트번호 : <%=request.getServerPort() %>
<p>
<li> 사용자 컴퓨터 주소: <%=request.getRemoteAddr() %>
<li> 사용자 컴퓨터 이름: <%=request.getRemoteHost() %>
<p>
<li> 현재 사용중인 웹 브라우저 : 
<%=request.getHeader("User-Agent") %>

<li> 브라우저를 지원하는 file의 type : text/html
<%=request.getHeader("Accept") %>

<li> 이전 url 알아내기: 
<%=request.getHeader("referer") %>

<%

%>

</body>
</html>