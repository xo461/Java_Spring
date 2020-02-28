<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
//post 요청 한글 처리
request.setCharacterEncoding("utf-8");
%>    
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forward2.jsp</title>
</head>
<body>

<jsp:forward page="forward3.jsp">
	<jsp:param name="tel" value="010-1111-1111" />
	<jsp:param name="email" value="mini@gmail.com"/>
</jsp:forward>
</body>
</html>