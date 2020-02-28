<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--     에러페이지로 연결해줌 -->
<%@page errorPage="09_err.jsp" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>09_exception.jsp</title>
</head>
<body>
<%
//지역변수
int a=7;
int b=0;
%>
0으로 나누면 에러가 발생 -> 에러창으로 넘어간다.
a/b=<%=a/b %><br> 

</body>
</html>