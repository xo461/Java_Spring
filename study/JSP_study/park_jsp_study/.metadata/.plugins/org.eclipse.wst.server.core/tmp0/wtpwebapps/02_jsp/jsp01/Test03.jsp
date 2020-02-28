<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test03.jsp</title>
</head>
<body>

<h2>jsp 주석</h2>
<%-- jsp주석은 숨은 주석이라고 한다. 
웹상에서 소스보기에서 보이지 않기 때문. --%>

<h2>java 주석</h2>
<%
//java주석도 보이지 않음.
//out.println("안녕")
/*out.println("hello")*/
%>

<h2>html 주석</h2>
<!-- 안녕
hello
보인다. -->
</body>
</html>