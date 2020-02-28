<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>클라이언트 및 서버정보</title>
</head>
<body>

<!-- jsp 기본객체는 jsp에 생성하지않아도 이미 생성되어있어서 사용할수있는 객체변수 -->
<!-- getremoteaddr(): 웹에 접속한 ip주소를 보여줌 -->
클라이언트 IP = <%=request.getRemoteAddr() %>
<% System.out.println(request.getRemoteAddr()); %>
요청정보길이 = <%= request.getContentLength() %><br/>
<!-- 한글처리 -->
<%request.setCharacterEncoding("utf-8"); %>
엔코딩 = <%= request.getContentLength() %><br/>
컨텐트 타입(요청 타입) = <%= request.getContentType() %><br/>
프로토콜 = <%= request.getProtocol() %><br/>
URL = <%= request.getRequestURI() %><br/>
경로(모듈) = <%= request.getContextPath() %><br/>
경로 (서버위치)= <%= request.getServletPath() %><br/>
서버이름= <%= request.getServerName() %><br/>
포트= <%= request.getServerPort() %><br/>
<h2>넘어오는 데이터 확인</h2>
글번호= <%= request.getParameter("no") %><br/>
증가여부= <%= request.getParameter("cnt") %><br/>
<h2>데이터를 저장하고 확인</h2>
<% request.setAttribute("name", "이영환"); %>
이름= <%= request.getAttribute("name") %><br/>
이름= ${name }<br/>
 
</body>
</html>